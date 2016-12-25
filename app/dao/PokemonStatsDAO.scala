package dao

import dao.PokemonsStatsDAO.PokemonsStatEntry
import slick.driver.PostgresDriver.api._

class PokemonsStatsDAO (tag: Tag) extends Table[PokemonsStatEntry](tag, "pokemons_stats"){
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def pvBase = column[Int]("pv_base")
  def pvAdd = column[Int]("pv_add")
  def attackBase = column[Int]("attack_base")
  def attackAdd = column[Int]("attack_add")
  def defenseBase = column[Int]("defense_base")
  def defenseAdd = column[Int]("defense_add")
  def specialAttackBase = column[Int]("special_attack_base")
  def specialAttackAdd = column[Int]("special_attack_add")
  def specialDefenseBase = column[Int]("special_defense_base")
  def specialDefenseAdd = column[Int]("special_defense_add")
  def vitesseBase = column[Int]("vitesse_base")
  def vitesseAdd = column[Int]("vitesse_add")
  def * = (
    id,
    pvBase,
    pvAdd,
    attackBase,
    attackAdd,
    defenseBase,
    defenseAdd,
    specialAttackBase,
    specialAttackAdd,
    specialDefenseBase,
    specialDefenseAdd,
    vitesseBase,
    vitesseAdd
    )
}


object PokemonsStatsDAO {
  type PokemonsStatEntry = (Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)
}


