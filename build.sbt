name := "TCard"

version := "1.0"

lazy val `tcard` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(cache, specs2 % Test)

libraryDependencies ++= Seq(
  /* Configuration */
  "com.typesafe" % "config" % "1.3.1",
  /* Play Slick */
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.0",
  /* Postgresql driver */
  "org.postgresql" % "postgresql" % "9.4.1212"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

/* Enables dependency injection for generators */
routesGenerator := InjectedRoutesGenerator