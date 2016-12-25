package models

import com.google.inject.{Inject, Singleton}
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
@Singleton
class CharacterSectionFactory extends SectionFactory {

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
@Singleton
class PokemonSectionFactory @Inject()(val service : PokemonService) extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("pokemons",
      "Ses terreurs nocturnes",
      "Puisque faute de les supporter en vrai, elle les voit en rêves...")
  }

  override protected def getFutureHtml() =
    service.all map {
      ps => views.html.pokemons(ps)
    }

}

/**
  * SectionFactory implementation that generates
  * posts Section
  */
@Singleton
class PostsSectionFactory @Inject()(val service : ChapterService) extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("posts",
      "Méfaits et gestes",
      "Puisqu'elle attire toujours plus l'attention qu'elle ne le voudrait...")
  }

  override protected def getFutureHtml() =
    service.all map {
      chapters => views.html.posts(chapters)
    }
}

/**
  * SectionFactory implementation that generates
  * links Section
  */
@Singleton
class LinksSectionFactory extends SectionFactory {

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
@Singleton
class TresorsSectionFactory extends SectionFactory {

  override protected def getFutureInfos() = Future {
    ("tresors",
      "Magots en pagaille...",
      "Puisqu'il est plus sympa de partager toutes ses richesses...")
  }

  override protected def getFutureHtml() =
    Future { views.html.tresors() }
}
