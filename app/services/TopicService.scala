package services

import javax.inject.Inject

import com.google.inject.ImplementedBy
import dao.TopicsDAO
import models.{Featuring, Solo, Someone, Topic}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

import javax.inject.Singleton

/**
  * Trait to handle topics.
  */

@ImplementedBy(classOf[TopicServiceImpl])
trait TopicService {

  def findByChapterId(chId: Int): Future[Seq[Topic]]

}

/**
  * TopicService implementation.
  */
@Singleton
class TopicServiceImpl @Inject()(
                                  val dbConfigProvider: DatabaseConfigProvider,
                                  val characterService: CharacterService
                                )
  extends TopicService with HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val topics = TableQuery[TopicsDAO]

  override def findByChapterId(chId: Int) = {
    val query = topics.filter(_.chapterId === chId)
    db.run(query.result) flatMap {
      Future.traverse(_) {
        topicEntry => featuringFromOptionalCharacterId(topicEntry._6) map {
          featuring => new Topic(topicEntry, featuring)
        }
      }
    }
  }

  /* Utilities */

  private def featuringFromOptionalCharacterId(optId: Option[Int]): Future[Featuring] = {
    optId map {
      characterService.findById(_)
    } match {
      case None => Future { Solo() }
      case Some(futureCh) => futureCh map { Someone(_) }
    }
  }


}

