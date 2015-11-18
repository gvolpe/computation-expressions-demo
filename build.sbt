name := """computation-expressions-demo"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-async" % "0.9.5",
  "org.scalaz" %% "scalaz-concurrent" % "7.1.5"
)

enablePlugins(JmhPlugin)
