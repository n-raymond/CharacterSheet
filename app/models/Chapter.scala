package models;



class Chapter(
        val id: String,
        val title: String,
        val subject: String,
        val summary: String,
        val image: String,
        val topics: Seq[Topic]
        )
