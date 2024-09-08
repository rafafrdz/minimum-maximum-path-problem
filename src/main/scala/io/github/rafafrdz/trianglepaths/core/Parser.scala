package io.github.rafafrdz.trianglepaths.core

object Parser {

  def parseTriangle(triangle: String): Triangle =
    triangle.trim.split("\n").map(parseRow).toList

  def parseRow(row: String): Row =
    row.trim.split(" ").map(_.toInt).toList
}
