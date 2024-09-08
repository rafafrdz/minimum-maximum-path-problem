package io.github.rafafrdz.core

import io.github.rafafrdz.trianglepaths.core.Triangle
import io.github.rafafrdz.trianglepaths.core.Triangle.Path
import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should.Matchers

class TriangleSpec extends AnyFlatSpecLike with Matchers {

  object Resources {
    val triangle =
      List(
        List(7),
        List(6, 3),
        List(3, 8, 5),
        List(11, 2, 10, 9)
      )

  }

  import Resources._

  "minimumPath" should "return the minimum path" in {

    Triangle.minPath(triangle) should be(Path(18, List(7, 6, 3, 2)))
  }


}
