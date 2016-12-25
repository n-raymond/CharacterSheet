package models

import java.awt.Color

import dao.CharactersDAO.CharactersEntry
import utils.StringUtils

case class Character(
                      val name: String,
                      val link: String,
                      val color: Color
                    ) {

  def this(e: CharactersEntry) = {
      this(e._2, e._3, Color.decode(e._4))
  }



  def className = StringUtils.standardToSnakeCase(name)

}
