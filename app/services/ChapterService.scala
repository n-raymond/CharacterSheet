package services

import java.awt.Color
import javax.inject._

import com.google.inject.ImplementedBy
import dao._
import exceptions.DataNotFoundException
import models._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

/**
  * Trait used to handle Chapters.
  */
@ImplementedBy(classOf[ChapterServiceImpl])
trait ChapterService {

  def all : Future[Seq[Chapter]]

}

/**
  * ChapterSerivce implementation.
  */
@Singleton
class ChapterServiceImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends ChapterService with HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val chapters = TableQuery[ChaptersDAO]
  private val topics = TableQuery[TopicsDAO]
  private val characters = TableQuery[CharactersDAO]

  /* Queries */

  override def all = {
    db.run(chapters.result) flatMap {
      Future.traverse(_) {
        chapterEntry => topicsByChapterId(chapterEntry._1) map {
          ts => new Chapter(chapterEntry, ts)
        }
      }
    }
  }

  private def topicsByChapterId(chId: Int): Future[Seq[Topic]] = {
    val query = topics.filter(_.chapterId === chId)
    db.run(query.result) flatMap {
      Future.traverse(_) {
        topicEntry => featuringFromOptionalCharacterId(topicEntry._6) map {
          featuring => new Topic(topicEntry, featuring)
        }
      }
    }
  }

  private def characterById(id: Int): Future[Character] = {
    val query = characters.filter(_.id === id)
    db.run(query.result) map {
      seq => seq match {
        case Seq() => throw new DataNotFoundException(s"No character can be find with the given id : $id")
        case _ => new Character(seq(0))
      }
    }
  }

  /* Utilities */

  private def featuringFromOptionalCharacterId(optId: Option[Int]): Future[Featuring] = {
    optId map {
      characterById(_)
    } match {
      case None => Future { Solo() }
      case Some(futureCh) => futureCh map { Someone(_) }
    }
  }








  /*override def all = Future {

    /* Characters */

    val astrid = new Character(
      "Astrid de Valnor",
      "http://master-poke.forumactif.fr/t8288-astrid-de-valnor",
      Color decode "#ffffff"
    )

    val maelys = new Character(
      "Maelys Sena",
      "http://master-poke.forumactif.fr/t4130-maelys-sena#44028",
      Color decode "#ffffff"
    )

    /* Topics */

    val jailsAndQueen = new Topic(
      "Jails ans Queen",
      "http://master-poke.forumactif.fr/t9395-jails-and-queen",
      Done(),
      Solo()
    )

    val priseLaMainDansLeSac = new Topic(
      "Prise la main dans le sac !",
      "http://master-poke.forumactif.fr/t10658-prise-la-main-dans-le-sac",
      Done(),
      Someone(astrid)
    )

    val theNeighboorBelow = new Topic(
      "The neighboor below",
      "http://master-poke.forumactif.fr/t10755-the-neighboor-below",
      Doing(),
      Someone(maelys)
    )

    val deFestivesRetrouvailles = new Topic(
      "De festives retrouvailles",
      "http://master-poke.forumactif.fr/t13758-de-festives-retrouvailles#241832",
      Doing(),
      Someone(astrid)
    )

    /* Chapters */

    val planA = Chapter(
      "A",
      "Home Sweet Home",
      "Où l'on meurt puis l'on vit.",
      """Incomprehensions.
        Pertes de contrôle et joies mesquines.
        Prises de risques.
        Conséquences.
        Bras de fers et poigne d'acier.
        Le petit orteil, celui qui fait bien mal.
        Des outils bien gardés.
        De l'eau oui, du thé non.""",
      "HomeSweetHome.png",
      Seq(jailsAndQueen, priseLaMainDansLeSac, theNeighboorBelow)
    )

    val planB = Chapter(
      "B",
      "Stayin' Alive",
      "Où l'on tente de rattrapper les pôts cassés.",
      """Apparition d'une bestiole peu sympatique.
        La gravité, cette traitresse.
        Des ennuis. Encore des ennuis.
        Drôle de manière de dormir.
        Dormir ? Pourquoi faire ?
        De l'art d'arriver en retard.""",
      "StayinAlive.png",
      Seq(deFestivesRetrouvailles)
    )

    Seq(planA, planB)

  }*/
}