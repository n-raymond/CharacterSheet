package services


import javax.inject._

import com.google.inject.ImplementedBy
import dao.{PokemonsAttacksDAO, PokemonsDAO, PokemonsStatsDAO}
import models.Pokemon
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._


/**
  * Trait use to handle Pokemons.
  */
@ImplementedBy(classOf[PokemonServiceImpl])
trait PokemonService {

  def all: Future[Seq[Pokemon]]

}

/**
  * PokemonService implementation.
  */
@Singleton
class PokemonServiceImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)
  extends PokemonService with HasDatabaseConfigProvider[JdbcProfile] {
  import driver.api._

  private val pokemons = TableQuery[PokemonsDAO]
  private val pokemonsStats = TableQuery[PokemonsStatsDAO]
  private val pokemonsAttacks = TableQuery[PokemonsAttacksDAO]

  /* Queries */

  override def all = {

    val query = for {
      p <- pokemons
      s <- pokemonsStats if p.statsId === s.id
    } yield (p, s)

    db.run(query.result) flatMap {
      Future.traverse(_) {
        case (pokemon, stats) => getAttacksByPokemonId(pokemon._1) map {
          attacks => new Pokemon(pokemon, stats, attacks)
        }
      }
    }

  }

  private def getAttacksByPokemonId(pid: Int) : Future[Seq[String]] = {
    val query = pokemonsAttacks.filter(_.pokemonId === pid).map(_.name)
    db.run(query.result)
  }

}
