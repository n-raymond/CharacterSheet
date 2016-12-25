package models

import dao.ChaptersDAO.ChaptersEntry



case class Chapter(
                    name: String,
                    title: String,
                    subject: String,
                    summary: String,
                    image: String,
                    topics: Seq[Topic]
                  ) {

  def this(e: ChaptersEntry, topics: Seq[Topic]) =
    this(e._2, e._3, e._4, e._5, e._6, topics)

}
