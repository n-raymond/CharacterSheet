package models

/**
  * Created by PixelMan on 21/12/2016.
  */
class PokemonStats(
                  val pv: (Int, Int),
                  val attack: (Int, Int),
                  val defense: (Int, Int),
                  val specialAttack: (Int, Int),
                  val spectialDefense: (Int, Int),
                  val vitesse: (Int, Int)
                  ) {

  val toSeq = Seq(
    ("PV", pv._1, pv._2),
    ("ATK", attack._1, attack._2),
    ("DEF", defense._1, defense._2),
    ("ATK S", specialAttack._1, specialAttack._2),
    ("DEF S", spectialDefense._1, spectialDefense._2),
    ("VIT", vitesse._1, vitesse._2)
  )

}
