package models

import dao.TopicsDAO.TopicsEntry

/**
  * Created by PixelMan on 23/12/2016.
  */
case class Topic(
           title: String,
           link: String,
           status: Status,
           featuring: Featuring
           ) {

  def this(e: TopicsEntry, featuring: Featuring) =
    this(e._3, e._4, Status(e._5), featuring)

}

