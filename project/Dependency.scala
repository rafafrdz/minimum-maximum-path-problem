import sbt._

object Dependency {

  object cats {
    lazy val core: ModuleID = "org.typelevel" %% "cats-core" % Version.Cats
  }

  object catsEffect {
    lazy val core: ModuleID = "org.typelevel" %% "cats-effect" % Version.CatsEffect
  }

  object fs2 {
    lazy val core: ModuleID = "co.fs2" %% "fs2-core" % Version.Fs2
    lazy val io: ModuleID = "co.fs2" %% "fs2-io" % Version.Fs2
  }

  object Testing {
    lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Version.ScalaTest % Test

    lazy val scalaTestFlatspec: ModuleID =
      "org.scalatest" %% "scalatest-flatspec" % Version.ScalaTest % Test

    lazy val scalaITest: ModuleID =
      "org.scalatest" %% "scalatest" % Version.ScalaTest % IntegrationTest

    lazy val scalaITestFlatspec: ModuleID =
      "org.scalatest" %% "scalatest-flatspec" % Version.ScalaTest % IntegrationTest

  }

}
