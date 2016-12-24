package models;



case class Chapter(
        id: String,
        title: String,
        subject: String,
        summary: String,
        image: String,
        topics: Seq[Topic]
        )
