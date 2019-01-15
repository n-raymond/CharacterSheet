name := """CharacterSheet"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
    guice,
    "com.typesafe" % "config" % "1.3.2",
    "com.typesafe.play" %% "play-slick" % "3.0.0",
    "org.postgresql" % "postgresql" % "9.4.1212",
    "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
)

/* Enables dependency injection for generators */
routesGenerator := InjectedRoutesGenerator

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "fr.pixelhub.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "fr.pixelhub.binders._"
