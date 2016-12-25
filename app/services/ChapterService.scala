package services

import java.awt.Color

import models._

import scala.concurrent._
import ExecutionContext.Implicits.global

import com.google.inject.ImplementedBy
import javax.inject._

/**
  * Trait use to handle Chapters.
  */
@ImplementedBy(classOf[ChapterServiceImpl])
trait ChapterService {

  def getChapters : Future[Seq[Chapter]]

}

/**
  * ChapterSerivce implementation.
  */
@Singleton
class ChapterServiceImpl extends ChapterService {

  /* TODO: Use CRUD to retrieve chapters */

  override def getChapters = Future {

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
      """Aapparition d'une bestiole peu sympatique.
        La gravité, cette traitresse.
        Des ennuis. Encore des ennuis.
        Drôle de manière de dormir.
        Dormir ? Pourquoi faire ?
        De l'art d'arriver en retard.""",
      "StayinAlive.png",
      Seq(deFestivesRetrouvailles)
    )

    Seq(planA, planB)

  }
}