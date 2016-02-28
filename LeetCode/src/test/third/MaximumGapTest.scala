package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumGapTest extends FunSuite with ShouldMatchers {
  val m = new MaximumGap

  test("should work") {
    m.maximumGap(Array()) should be(0)
    m.maximumGap(Array(1)) should be(0)
    m.maximumGap(Array(3,1)) should be(2)
    m.maximumGap(Array(3,1,4)) should be(2)
    m.maximumGap(Array(3,1,4,5)) should be(2)
    m.maximumGap(Array(3,1,4,8)) should be(4)
    m.maximumGap(Array(7,8,1,5,4,10)) should be(3)
    m.maximumGap(Array(0,10,4)) should be(6)
    m.maximumGap(Array(0,1000,999)) should be(999)
    m.maximumGap(Array(1,1000,999)) should be(998)
    m.maximumGap(Array(1000,999)) should be(1)
    m.maximumGap(Array(3,6,9,1)) should be(3)
  }
}
