package models;


case class Chapter(
                    name: String,
                    title: String,
                    subject: String,
                    summary: String,
                    image: String,
                    topics: Seq[Topic]
                  )
