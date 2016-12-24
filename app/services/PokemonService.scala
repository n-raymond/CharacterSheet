package services

import com.google.inject.ImplementedBy
import models.{Pokemon, PokemonStats}

import scala.concurrent._
import ExecutionContext.Implicits.global

/**
  * Trait use to handle Pokemons.
  */
@ImplementedBy(classOf[PokemonServiceImpl])
trait PokemonService {

  def getPokemons: Future[Seq[Pokemon]]

}

/**
  * PokemonService implementation.
  */
class PokemonServiceImpl extends PokemonService {

  /* TODO: Use CRUD to retrieve pokemons */

  override def getPokemons = Future {
    val tarsal = new Pokemon(
      "Tarsal",
      "Gordon",
      "Psy Fée",
      6,
      "Obstiné",
      "Tarsal.png",
      new PokemonStats(
        (28, 2),
        (25, 0),
        (25, 1),
        (45, 2),
        (35, 1),
        (40, 2)
      ),
      Seq("Rugissement", "Choc Mental")
    )

    val prismillon = new Pokemon(
      "Prismillon",
      "Tartenpion",
      "Insecte Vol",
      15,
      "Festif",
      "Prismillon.png",
      new PokemonStats(
        (28, 2),
        (25, 0),
        (25, 1),
        (45, 2),
        (35, 1),
        (40, 2)
      ),
      Seq(
        "Mur Lumière",
        "Nuée de Poudre",
        "Para-Spore",
        "Poudre Dodo",
        "Poudre Toxik",
        "Tornade",
        "Survinsecte"
      )
    )

    Seq(tarsal, prismillon)
  }

}
