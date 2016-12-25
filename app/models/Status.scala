package models

import exceptions.NotMappableException

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


object Status {
  def apply(str: String) = str match {
    case "done" => Done()
    case "doing" => Doing()
    case "incoming" => Incoming()
    case _ => throw new NotMappableException(s"String '$str' can't be mapped to a status.")
  }
}