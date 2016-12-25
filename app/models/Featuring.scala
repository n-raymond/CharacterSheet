package models

sealed abstract class Featuring

case class Solo() extends Featuring

case class Someone(character: Character) extends Featuring

object Featuring {
  def apply(character: Option[Character]) = character match {
    case None => Solo()
    case Some(c) => Someone(c)
  }
}