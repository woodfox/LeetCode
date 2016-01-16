package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MinimumPathsSumTest extends FunSuite with ShouldMatchers {
  val t = new MinimumPathsSum

  test("should find minimum path sum") {
    t.minPathSum(Array(Array(1))) should be(1)
    t.minPathSum(Array(Array(1,2,3))) should be(6)
    t.minPathSum(Array(Array(1),Array(2),Array(3))) should be(6)
    t.minPathSum(Array(Array(1,0),Array(1,2))) should be(3)
    t.minPathSum(Array(Array(1,2),Array(1,0))) should be(2)
    t.minPathSum(Array(Array(1,2,2),Array(1,4,0))) should be(5)
  }
}
