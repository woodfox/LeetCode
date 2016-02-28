package util

trait PointHelper {
  def createPoints(points: List[(Int, Int)]): List[Point] = {
    points.map { case (x, y) =>
      new Point(x, y)
    }
  }
}
