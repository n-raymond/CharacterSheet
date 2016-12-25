package models

import dao.PokemonsStatsDAO

/**
  * Created by PixelMan on 21/12/2016.
  */
case class PokemonStats(
                         pv: (Int, Int),
                         attack: (Int, Int),
                         defense: (Int, Int),
                         specialAttack: (Int, Int),
                         spectialDefense: (Int, Int),
                         vitesse: (Int, Int)
                       ) {

  def this(e: PokemonsStatsDAO.PokemonsStatEntry) =
    this((e._2, e._3), (e._4, e._5), (e._6, e._7), (e._8, e._9), (e._10, e._11), (e._12, e._13))

  val toSeq = Seq(
    ("PV", pv._1, pv._2),
    ("ATK", attack._1, attack._2),
    ("DEF", defense._1, defense._2),
    ("ATK S", specialAttack._1, specialAttack._2),
    ("DEF S", spectialDefense._1, spectialDefense._2),
    ("VIT", vitesse._1, vitesse._2)
  )

}
