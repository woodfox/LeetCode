package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumRangeTest extends FunSuite with ShouldMatchers {
  val m = new MaximumRange

  test("should work") {
    m.maximumRange(Array()) should be(0)
    m.maximumRange(Array(3)) should be(0)
    m.maximumRange(Array(3,6)) should be(0)
    m.maximumRange(Array(3,6,2)) should be(1)
    m.maximumRange(Array(3,6,2,4)) should be(2)
    m.maximumRange(Array(3,6,2,4,5)) should be(4)
    m.maximumRange(Array(3,6,2,4,7,5)) should be(5)
    m.maximumRange(Array(3,6,2,4,7,5,9,10)) should be(5)
    m.maximumRange(Array(3,6,2,4,7,5,9,10,8)) should be(8)
  }
}
