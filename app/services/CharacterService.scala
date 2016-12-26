package services

import javax.inject._

import com.google.inject.ImplementedBy
import dao.CharactersDAO
import exceptions.DataNotFoundException
import models.Character
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

/**
  * Trait use to handle characters.
  */
@ImplementedBy(classOf[CharacterServiceImpl])
trait CharacterService {

  def all : Future[Seq[Character]]

  def findById(id: Int): Future[Character]

}

/**
  * CharacterService implementations
  */
@Singleton
class CharacterServiceImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends CharacterService with HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val characters = TableQuery[CharactersDAO]

  override def all = {
    db.run(characters.result) map {
      _ map { new Character(_) }
    }

  }

  override def findById(id: Int) = {
    val query = characters.filter(_.id === id)
    db.run(query.result) map {
      seq => seq match {
        case Seq() => throw new DataNotFoundException(s"No character can be find with the given id : $id")
        case _ => new Character(seq(0))
      }
    }
  }

}