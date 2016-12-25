package models

sealed abstract class Featuring

case class Solo() extends Featuring

case class Someone(character: Character) extends Featuring
