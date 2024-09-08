package io.github.rafafrdz.trianglepaths.io

import cats.effect.Async
import cats.effect.kernel.Resource
import io.github.rafafrdz.trianglepaths.core.Parser.parseTriangle
import io.github.rafafrdz.trianglepaths.core.Triangle

object Parser {

  def parseFile[F[_]: Async](file: String): Resource[F, Triangle] = {
    Resource.fromAutoCloseable(Async[F].delay(scala.io.Source.fromFile(file))).map { source =>
      parseTriangle(source.mkString)
    }
  }

}
