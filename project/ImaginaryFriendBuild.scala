// Copyright 2016 Sam Halliday
// Licence: http://www.apache.org/licenses/LICENSE-2.0
import sbt._
import Keys._
import SonatypeSupport._

object ImaginaryFriendBuild extends Build {
  lazy val root = Project("imaginary-friend", file(".")).
    settings(Sensible.settings).
    settings(sonatype("fommil", "imaginary-friend", Apache2)).
    settings(
      organization := "com.fommil",
      scalaVersion := "2.11.7",
      version := "1.0.0-SNAPSHOT",
      libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-compiler" % scalaVersion.value,
        "org.typelevel" %% "macro-compat" % "1.1.0"
      ) ++ Sensible.testLibs() ++ Sensible.macroParadise,
      updateOptions := updateOptions.value.withCachedResolution(true)
    )
}
