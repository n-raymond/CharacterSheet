package models

import utils.StringUtils

/**
  * Created by PixelMan on 21/12/2016.
  */
case class Pokemon(
             pokemon: String,
             name: String,
             typ: String,
             level: Int,
             nature: String,
             sprite: String,
             stats: PokemonStats,
             attacks: Seq[String]
             ) {

  def id = StringUtils standardToHyphenCase pokemon

  def className = StringUtils standardToSnakeCase typ


}