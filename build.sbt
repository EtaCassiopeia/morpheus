import Dependencies._

lazy val core = (project in file("core"))
  .settings(Settings.commonSettings: _*)
  .settings(
    libraryDependencies ++= cats ++ catsTagless ++ catsEffectKernel ++
      (catsLaws ++ catsEffectLaws ++ catsEffect ++ catsTestkit ++ catsEffectTestKit ++ kittens)
        .map(_ % Test)
  )
  .settings(name := "morpheus-core")

lazy val akkaRuntime = (project in file("akka-runtime"))
  .dependsOn(core)
  .settings(Settings.commonSettings: _*)
  .settings(libraryDependencies ++= catsEffectStd)
  .settings(name := "morpheus-runtime-akka")

lazy val kalixRuntime = (project in file("kalix-runtime"))
  .dependsOn(core)
  .settings(Settings.commonSettings: _*)
  .settings(libraryDependencies ++= catsEffectStd)
  .settings(name := "morpheus-runtime-kalix")

lazy val zioEntityRuntime = (project in file("zio-entity-runtime"))
  .dependsOn(core)
  .settings(Settings.commonSettings: _*)
  .settings(libraryDependencies ++= catsEffectStd)
  .settings(name := "morpheus-runtime-zio-entity")

lazy val root = (project in file("."))
  .aggregate(core,akkaRuntime,kalixRuntime,zioEntityRuntime)
  .settings(Settings.commonSettings: _*)
  .settings(publish / skip := true)
  .settings(
    name := "morpheus"
  )

