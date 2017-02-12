logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

/* Sbt for play */
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.9")

/* Sass compilation */
addSbtPlugin("org.irundaia.sbt" % "sbt-sassify" % "1.4.2")
