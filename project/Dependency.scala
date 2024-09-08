import sbt._

object Dependency {

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
