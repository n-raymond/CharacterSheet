package models

import dao.{PokemonsDAO, PokemonsStatsDAO}
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

  def this(p: PokemonsDAO.PokemonEntry, s: PokemonsStatsDAO.PokemonsStatEntry, a: Seq[String]) =
    this(p._2, p._3, p._4, p._5, p._6, p._7, new PokemonStats(s), a)

  def formattedName = StringUtils standardToSnakeCase name

  def formattedType = StringUtils standardToSnakeCase typ

}