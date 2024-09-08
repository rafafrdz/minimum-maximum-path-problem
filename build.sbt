ThisBuild / version := "0.1.0"

ThisBuild / scalaVersion := Version.Scala

lazy val root = (project in file("."))
  .settings(
    name := "minimum-maximum-path-problem",
    libraryDependencies ++= Seq(
      Dependency.cats.core,
      Dependency.catsEffect.core,
      Dependency.Testing.scalaTest,
      Dependency.Testing.scalaTestFlatspec,
      Dependency.Testing.scalaITest,
      Dependency.Testing.scalaITestFlatspec
    ),
    Compile / packageBin / mainClass := Some("io.github.rafafrdz.trianglepaths.app.MinTrianglePath")
  )
