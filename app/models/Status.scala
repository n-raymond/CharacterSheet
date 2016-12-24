package models

sealed abstract class Status

case class Done() extends Status {
  override def toString = "done"
}

case class Doing() extends Status {
  override def toString = "doing"
}

case class Incoming() extends Status {
  override def toString = "incoming"
}