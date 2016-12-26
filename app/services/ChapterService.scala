package services

import javax.inject._

import com.google.inject.ImplementedBy
import dao._
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
class ChapterServiceImpl @Inject()(
                                    val dbConfigProvider: DatabaseConfigProvider,
                                    val topicService: TopicService
                                  )
  extends ChapterService with HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val chapters = TableQuery[ChaptersDAO]

  /* Queries */

  override def all = {
    db.run(chapters.result) flatMap {
      Future.traverse(_) {
        chapterEntry => topicService.findByChapterId(chapterEntry._1) map {
          ts => new Chapter(chapterEntry, ts)
        }
      }
    }
  }

}