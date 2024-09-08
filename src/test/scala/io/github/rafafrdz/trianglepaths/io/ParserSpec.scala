package io.github.rafafrdz.trianglepaths.io

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import io.github.rafafrdz.trianglepaths.core.Triangle
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class ParserSpec extends AnyFlatSpecLike with Matchers {

  "Parser" should "return a valid matrix from a source in resource test folder" in {

    val unsafeTriangle: Triangle =
      Parser
        .parseFile[IO]("src/test/resources/triangle-example.txt")
        .compile
        .lastOrError
        .unsafeRunSync()

    unsafeTriangle shouldBe List(
      List(7),
      List(6, 3),
      List(3, 8, 5),
      List(11, 2, 10, 9)
    )
  }

}
