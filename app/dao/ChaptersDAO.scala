package dao

import dao.ChaptersDAO.ChaptersEntry
import slick.driver.PostgresDriver.api._

class ChaptersDAO(tag: Tag) extends Table[ChaptersEntry](tag, "chapters") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def title = column[String]("title")
  def subject = column[String]("subject")
  def summary = column[String]("summary")
  def image = column[String]("image")
  def * = (id, name, title, subject, summary, image)
}

object ChaptersDAO {
  type ChaptersEntry = (Int, String, String, String, String, String)
}