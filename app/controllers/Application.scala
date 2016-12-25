package controllers

import com.google.inject.Inject
import models._
import play.api.mvc._

import scala.concurrent._
import ExecutionContext.Implicits.global


class Application @Inject()(
                             characterSF: CharacterSectionFactory,
                             pokemonSF: PokemonSectionFactory,
                             postsSF: PostsSectionFactory,
                             linksSF: LinksSectionFactory,
                             tresorsSF: TresorsSectionFactory
                           ) extends Controller {

  def index = Action.async {

    val sectionFactories = Seq(characterSF, pokemonSF, postsSF, linksSF, tresorsSF)

    val futureSections : Future[Seq[Section]] = Future.traverse(sectionFactories) {
      factory => factory.apply()
    }

    futureSections.map(sections => Ok(views.html.index(sections)))

  }

}