package io.github.rafafrdz.trianglepaths.io

import cats.effect.kernel.Async
import io.github.rafafrdz.trianglepaths.core.Triangle

object Console {

  sealed trait Commands
  case object STDIN             extends Commands
  case class FILE(file: String) extends Commands

  def parseCommand(args: List[String]): Commands =
    args match {
      case "-c" :: Nil         => STDIN
      case "-f" :: file :: Nil => FILE(file)
      case _                   => throw new IllegalArgumentException("Invalid arguments")
    }

  def eval[F[_]: Async](commands: Commands): fs2.Stream[F, Triangle] = commands match {
    case STDIN      => Parser.parseStdin[F]
    case FILE(file) => Parser.parseFile[F](file)
  }

  def command[F[_]: Async](args: List[String]): fs2.Stream[F, Commands] =
    fs2.Stream.eval(Async[F].delay(parseCommand(args)))

}
