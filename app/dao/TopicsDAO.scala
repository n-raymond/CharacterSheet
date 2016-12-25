package dao

import dao.TopicsDAO.TopicsEntry
import slick.driver.PostgresDriver.api._

class TopicsDAO (tag: Tag) extends Table[TopicsEntry](tag, "topics") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def chapterId = column[Int]("chapter_id")
  def name = column[String]("name")
  def link = column[String]("link")
  def status = column[String]("status")
  def featuring = column[Option[Int]]("featuring")
  def * = (id, chapterId, name, link, status, featuring)
}

object TopicsDAO {
  type TopicsEntry = (Int, Int, String, String, String, Option[Int])
}
