package dao

import dao.CharactersDAO.CharactersEntry
import slick.driver.PostgresDriver.api._

class CharactersDAO(tag: Tag) extends Table[CharactersEntry](tag, "characters"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def link = column[String]("link")
  def color = column[String]("color")
  def * = (id, name, link, color)
}

object CharactersDAO {
  type CharactersEntry = (Int, String, String, String)
}
