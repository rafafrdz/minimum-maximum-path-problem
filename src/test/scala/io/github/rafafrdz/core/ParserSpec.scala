package io.github.rafafrdz.core

import io.github.rafafrdz.trianglepaths.core.Parser
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class ParserSpec extends AnyFlatSpecLike with Matchers {

  object Resources {
    val triangle: String =
      """    7
        |   6 3
        |  3 8 5
        |11 2 10 9
        |""".stripMargin

  }

  import Resources._

  "Parser" should "return a valid array from a row" in {

    Parser.parseRow("7") should be(Array(7))
    Parser.parseRow("6 3") should be(Array(6, 3))
    Parser.parseRow("3 8 5") should be(Array(3, 8, 5))
    Parser.parseRow("11 2 10 9") should be(Array(11, 2, 10, 9))
  }

  it should "return a valid matrix from a triangle string" in {

    Parser.parseTriangle(triangle) should be(
      Vector(
        Vector(7),
        Vector(6, 3),
        Vector(3, 8, 5),
        Vector(11, 2, 10, 9)
      )
    )
  }

}
