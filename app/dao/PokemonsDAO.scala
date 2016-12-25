package dao

import dao.PokemonsDAO.PokemonEntry
import slick.driver.PostgresDriver.api._


class PokemonsDAO(tag: Tag) extends Table[PokemonEntry](tag, "pokemons"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def pokemon = column[String]("pokemon")
  def name = column[String]("name")
  def typ = column[String]("type")
  def lvl = column[Int]("lvl")
  def nature = column[String]("nature")
  def sprite = column[String]("sprite")
  def statsId = column[Int]("stats_id")
  def * = (id, pokemon, name, typ, lvl, nature, sprite, statsId)
}

object PokemonsDAO {
  type PokemonEntry = (Int, String, String, String, Int, String, String, Int)
}