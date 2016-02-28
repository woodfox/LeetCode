package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumProductSubArrayTest extends FunSuite with ShouldMatchers {
  val m = new MaximumProductSubArray

  test("should work") {
    m.maxProduct(Array(1)) should be(1)
    m.maxProduct(Array(-1)) should be(-1)
    m.maxProduct(Array(-1,-2)) should be(2)
    m.maxProduct(Array(-1,-2,-3)) should be(6)
    m.maxProduct(Array(-1,2,-3)) should be(6)
    m.maxProduct(Array(1,2,-3)) should be(2)
    m.maxProduct(Array(1,2)) should be(2)
    m.maxProduct(Array(1,2,-3)) should be(2)
    m.maxProduct(Array(-1,2,-3)) should be(6)
    m.maxProduct(Array(1,2,-3,4)) should be(4)
    m.maxProduct(Array(1,-2,-3,4,-1)) should be(24)
  }
}
