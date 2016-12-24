package models

import play.twirl.api.Html
import services._

class Section(
               val name: String,
               val title: String,
               val subTitle: String,
               val html: Html
             ) {

  def this(infos: (String, String, String), html: Html) =
    this(infos._1, infos._2, infos._3, html)

}

object Section {
  def apply(name: String) = name match {
    case "character"  => CharacterSectionFactory()
    case "pokemons"   => PokemonSectionFactory()
    case "posts"      => PostsSectionFactory()
    case "links"      => LinksSectionFactory()
    case "tresors"    => TresorsSectionFactory()
  }
}


