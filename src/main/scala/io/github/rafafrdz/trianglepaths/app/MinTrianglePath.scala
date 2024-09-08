package io.github.rafafrdz.trianglepaths.app

import cats.effect.std.{Console => Logger}
import cats.effect.{Async, ExitCode, IO, IOApp}
import io.github.rafafrdz.trianglepaths.core.Triangle
import io.github.rafafrdz.trianglepaths.io.Console

object MinTrianglePath extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    execute[IO](args).compile.drain.as(ExitCode.Success)

  def printOutput[F[_]: Async: Logger](path: Triangle.Path, triangle: Triangle): fs2.Stream[F, Nothing] = {
    val triangleLog = triangle.map(_.mkString(" ")).mkString("\n")
    val infoOutput  = s"Minimum path is: ${path.path.mkString(" + ")} = ${path.sum}"
    fs2.Stream
      .evals[F, List, String](Async[F].delay(List(triangleLog, infoOutput)))
      .foreach(info => Logger[F].println(info))
  }

  def execute[F[_]: Async: Logger](args: List[String]): fs2.Stream[F, Triangle.Path] =
    for {
      commands <- Console.command[F](args)
      triangle <- Console.eval[F](commands)
      path = Triangle.minPath(triangle)
      _ <- printOutput[F](path, triangle)
    } yield path
}
