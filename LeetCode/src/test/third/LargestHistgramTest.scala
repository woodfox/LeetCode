package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LargestHistgramTest extends FunSuite with ShouldMatchers{
  val l = new LargestHistgram

  test("should work"){
    l.largestRectangleArea(Array(1,2,3)) should be(4)
    l.largestRectangleArea(Array(3,2,1)) should be(4)
    l.largestRectangleArea(Array(1,1,1)) should be(3)
    l.largestRectangleArea(Array(1,0,1)) should be(1)
    l.largestRectangleArea(Array(2,1,2)) should be(3)
    l.largestRectangleArea(Array(2,4,2)) should be(6)
    l.largestRectangleArea(Array(2)) should be(2)
    l.largestRectangleArea(Array(0)) should be(0)
    l.largestRectangleArea(Array(2,8)) should be(8)
    l.largestRectangleArea(Array(8,2)) should be(8)
    l.largestRectangleArea(Array(2,2,2,2)) should be(8)
  }

}
