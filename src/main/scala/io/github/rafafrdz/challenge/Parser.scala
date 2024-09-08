package io.github.rafafrdz.challenge

object Parser {

  def parseRow(row: String): Array[Int] =
    row.trim.split(" ").map(_.toInt)

  def parseTriangle(triangle: String): Array[Array[Int]] =
    triangle.trim.split("\n").map(parseRow)
}
