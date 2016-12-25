package models

import play.twirl.api.Html

case class Section(
               name: String,
               title: String,
               subTitle: String,
               html: Html
             ) {

  def this(infos: (String, String, String), html: Html) =
    this(infos._1, infos._2, infos._3, html)

}