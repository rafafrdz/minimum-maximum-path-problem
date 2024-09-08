package io.github.rafafrdz.trianglepaths.app

import cats.effect.{ExitCode, IO, IOApp}
import io.github.rafafrdz.trianglepaths.core.Triangle
import io.github.rafafrdz.trianglepaths.io.Parser

object MinTrianglePath extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    for {
      pathArg <- IO.fromOption(args.headOption)(
        new IllegalArgumentException("File path not provided")
      )
      _ <- Parser.parseFile[IO](pathArg).use { triangle =>
        val minPath: Triangle.Path = Triangle.minPath(triangle)
        IO.println(triangle.map(_.mkString(" ")).mkString("\n")) >>
          IO.println(s"Minimum path is: ${minPath.path.mkString(" + ")} = ${minPath.sum}")
      }

    } yield ExitCode.Success
}
