package models

import utils.StringUtils

/**
  * Created by PixelMan on 21/12/2016.
  */
class Pokemon(
             val pokemon: String,
             val name: String,
             val typ: String,
             val level: Int,
             val nature: String,
             val sprite: String,
             val stats: PokemonStats,
             val attacks: Seq[String]
             ) {

  def id = StringUtils standardToHyphenCase pokemon

  def className = StringUtils standardToSnakeCase typ


}