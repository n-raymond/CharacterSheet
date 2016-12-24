package models

import java.awt.Color

import utils.StringUtils

class Character(
               val name: String,
               val link: String,
               val color: Color
               ) {

  def className = StringUtils.standardToSnakeCase(name)

}