package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RangeSumQuery2DMutableTest extends FunSuite with ShouldMatchers {
  test("should work"){
    val t = new RangeSumQuery2DMutable(Array(Array(1,2,3,4),Array(1,2,3,4),Array(1,2,3,4)))

    t.sumRange(1,1,2,3) should be(18)
    t.update(0,1,3)
    t.sumRange(1,1,2,3) should be(18)
    t.update(1,1,3)
    t.sumRange(1,1,2,3) should be(19)
    t.update(2,1,4)
    t.sumRange(1,1,2,3) should be(21)
    t.update(2,2,4)
    t.sumRange(1,1,2,3) should be(22)
  }
}
