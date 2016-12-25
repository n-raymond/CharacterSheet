package dao

import dao.PokemonsAttacksDAO.PokemonAttacksEntry
import slick.driver.PostgresDriver.api._

class PokemonsAttacksDAO(tag: Tag) extends Table[PokemonAttacksEntry](tag, "pokemons_attacks"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def pokemonId = column[Int]("pokemon_id")
  def name = column[String]("name")
  def * = (id, pokemonId, name)
}

object PokemonsAttacksDAO {
  type PokemonAttacksEntry = (Int, Int, String)
}