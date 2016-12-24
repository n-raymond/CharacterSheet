logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe" % "config" % "1.3.1"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.9")