import sbt._
import sbt.Keys._
import sbt.nio.Keys.{ReloadOnSourceChanges, onChangedBuildSource}

object Dependencies {

  object V {
    lazy val catsVersion = "2.8.0"
    lazy val catsTaglessVersion = "0.14.0"
    lazy val catsEffectVersion = "3.3.14"
    lazy val kittensVersion = "2.3.0"
    lazy val scalaTestVersion = "3.2.11"
  }

  import V._

  lazy val cats =
    Seq(
      "org.typelevel" %% "cats-core",
      "org.typelevel" %% "cats-kernel"
    ).map(_ % catsVersion)

  lazy val catsLaws = Seq("org.typelevel" %% "cats-laws" % catsVersion)
  lazy val catsTestkit = Seq("org.typelevel" %% "cats-testkit" % catsVersion)

  lazy val catsTagless = Seq(
    "org.typelevel" %% "cats-tagless-macros" % catsTaglessVersion
  )

  lazy val catsEffectKernel = Seq(
    "org.typelevel" %% "cats-effect-kernel" % catsEffectVersion
  )
  lazy val catsEffectLaws = Seq(
    "org.typelevel" %% "cats-effect-laws" % catsEffectVersion
  )
  lazy val catsEffectTestKit = Seq(
    "org.typelevel" %% "cats-effect-testkit" % catsEffectVersion
  )
  lazy val catsEffectStd = Seq(
    "org.typelevel" %% "cats-effect-std" % catsEffectVersion
  )
  lazy val catsEffect = Seq(
    "org.typelevel" %% "cats-effect" % catsEffectVersion
  )

  lazy val kittens = Seq("org.typelevel" %% "kittens" % kittensVersion)

  lazy val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
}

object Settings {
  val commonSettings = Seq(
    scalacOptions ++= Seq("-Xfatal-warnings"),
    addCompilerPlugin(
      "org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full
    ),
    scalaVersion     := "2.13.8",
      version          := "0.1.0-SNAPSHOT",
  organization     := "com.github.EtaCassiopeia",
    Global / onChangedBuildSource := ReloadOnSourceChanges
  )
}
