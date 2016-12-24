package models

import com.google.inject.Inject
import play.twirl.api.Html
import services.{ChapterService, ChapterServiceImpl, PokemonService, PokemonServiceImpl}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._

/**
  * Trait that generates a Section
  */
trait SectionFactory {

  protected def getFutureInfos() : Future[(String, String, String)]

  protected def getFutureHtml() : Future[Html]

  def apply() = for {
    infos <- getFutureInfos()
    html <- getFutureHtml()
  } yield new Section(infos, html)

}

/**
  * SectionFactory implementation that generates
  * character Section
  */
object CharacterSectionFactory extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("character",
      "Qui ça ?",
      "Puisqu'il est inadimissible qu'elle puisse toujours et encore croiser votre chemin...")
  }

  override protected def getFutureHtml() =
    Future { views.html.character() }
}


/**
  * SectionFactory implementation that generates
  * pokemon Section
  */
object PokemonSectionFactory extends SectionFactory {

  @Inject
  val service : PokemonService = new PokemonServiceImpl

  override protected def getFutureInfos() = Future {
    ("pokemons",
      "Ses terreurs nocturnes",
      "Puisque faute de les supporter en vrai, elle les voit en rêves...")
  }

  override protected def getFutureHtml() =
    service.getPokemons map {
      ps => views.html.pokemons(ps)
    }

}

/**
  * SectionFactory implementation that generates
  * posts Section
  */
object PostsSectionFactory extends SectionFactory {

  @Inject
  val service : ChapterService = new ChapterServiceImpl

  override protected def getFutureInfos() = Future {
    ("posts",
      "Méfaits et gestes",
      "Puisqu'elle attire toujours plus l'attention qu'elle ne le voudrait...")
  }

  override protected def getFutureHtml() =
    service.getChapters map {
      chapters => views.html.posts(chapters)
    }
}

/**
  * SectionFactory implementation that generates
  * links Section
  */
object LinksSectionFactory extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("links",
      "PickPoké'Dex",
      "Puisque voler est fun, mais collectioner c'est encore mieux...")
  }

  override protected def getFutureHtml() =
    Future { views.html.links() }
}

/**
  * SectionFactory implementation that generates
  * tresors Section
  */
object TresorsSectionFactory extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("tresors",
      "Magots en pagaille...",
      "Puisqu'il est plus sympa de partager toutes ses richesses...")
  }

  override protected def getFutureHtml() =
    Future { views.html.tresors() }
}
