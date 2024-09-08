package io.github.rafafrdz.trianglepaths.core

object Triangle {

  /**
   * Find the path with the minimum sum in the triangle
   * @param triangle the triangle to search
   * @return the path with the minimum sum
   */
  def minPath(triangle: Triangle): Path = searchPath(triangle)(_ < _)

  /**
   * Find the path following a given criteria condition sum in the triangle
   * @param triangle the triangle to search
   * @return the path which sum holds the criteria
   */
  def searchPath(triangle: Triangle)(criteria: (Int, Int) => Boolean): Path = {
    // Base case: the last row is the initial set of paths
    def combineRows(upper: List[Int], lower: List[Path]): List[Path] = {
      upper.zip(lower zip lower.tail).map {
        case (value, (left, right)) if criteria(left.sum, right.sum) =>
          Path(value + left.sum, value :: left.path)
        case (value, (_, right)) => Path(value + right.sum, value :: right.path)
      }
    }

    // Start with the last row as paths with no further levels
    val lastRowPaths: List[Path] = triangle.last.map(num => Path(num, List(num)))

    // Reduce the triangle from bottom to top, combining each row
    val resultPaths: List[Path] = triangle.init.foldRight(lastRowPaths)(combineRows)

    // The top element now holds the defined criteria condition sum and the corresponding path
    resultPaths.head
  }

  case class Path(sum: Int, path: List[Int])

}
