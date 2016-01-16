package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class UniquePathsIITest extends FunSuite with ShouldMatchers {
  val u = new UniquePathsII

  test("should find all paths") {
    u.uniquePathsWithObstacles(Array(Array(0,0), Array(0,0))) should be(2)
    u.uniquePathsWithObstacles(Array(Array(1,0), Array(0,0))) should be(0)
    u.uniquePathsWithObstacles(Array(Array(0,0,0), Array(0,1,0),Array(0,0,0))) should be(2)
    u.uniquePathsWithObstacles(Array(Array(0,0,0), Array(0,0,0),Array(0,0,0))) should be(6)
  }
}
