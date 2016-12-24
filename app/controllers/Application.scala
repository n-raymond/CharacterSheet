package controllers

import models.Section
import play.api.mvc._

import scala.concurrent._
import ExecutionContext.Implicits.global


class Application extends Controller {

  import Application._

  def index = Action.async {

    val futureSections : Future[Seq[Section]] = Future.traverse(SECTION_NAMES) {
      name => Section(name)
    }

    futureSections.map(sections => Ok(views.html.index(sections)))

  }

}

object Application {

  //TODO: Externalize me in confs
  final val SECTION_NAMES = Seq("character", "pokemons", "posts", "links", "tresors")

}