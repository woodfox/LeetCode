package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumArrayWithSumTest extends FunSuite with ShouldMatchers {
  val t = new MaximumArrayWithSum

  test("should work") {
    t.maxSubArrayLen(Array(1,-1,5,-2,3), 3) should be(4)
    t.maxSubArrayLen(Array(-2,-1,2,1), 1) should be(2)
    t.maxSubArrayLen(Array(-2,-1,2,1), 2) should be(3)
    t.maxSubArrayLen(Array(-2,-1,2,1), 0) should be(4)
    t.maxSubArrayLen(Array(-2,-1,2,1), 1) should be(2)
    t.maxSubArrayLen(Array(-2,-1,2,1), 3) should be(2)
    t.maxSubArrayLen(Array(-2,-1,2,1), -3) should be(2)
    t.maxSubArrayLen(Array(-1,-2,-3,-4,-5,-6,1,2,3,4), -1) should be(6)
  }
}
