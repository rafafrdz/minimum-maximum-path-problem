package io.github.rafafrdz.trianglepaths.io

import cats.effect.Async
import fs2.io.file.{Files, Path}
import fs2.io.stdinUtf8
import io.github.rafafrdz.trianglepaths.core.Parser.parseTriangle
import io.github.rafafrdz.trianglepaths.core.Triangle

object Parser {

  def parseFile[F[_]: Async](file: String): fs2.Stream[F, Triangle] =
    Files[F].readUtf8(Path(file)).map(parseTriangle)

  def parseStdin[F[_]: Async]: fs2.Stream[F, Triangle] =
    stdinUtf8(1024).map(parseTriangle)

}
