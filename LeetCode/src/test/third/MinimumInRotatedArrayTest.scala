package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MinimumInRotatedArrayTest extends FunSuite with ShouldMatchers {
  val m = new MinimumInRotatedArray

  test("should work") {
    m.findMin(Array(1)) should be(1)
    m.findMin(Array(1,2)) should be(1)
    m.findMin(Array(3,1,2)) should be(1)
    m.findMin(Array(3,4,1,2)) should be(1)
    m.findMin(Array(3,4,5,1,2)) should be(1)
    m.findMin(Array(3,4,5,6,1,2)) should be(1)
    m.findMin(Array(3,4,5,6,7,1,2)) should be(1)
    m.findMin(Array(3,4,5,6,7,8,1)) should be(1)
    m.findMin(Array(5,6,7,8,9,1,2,3)) should be(1)
    m.findMin(Array(5,6,7,8,9,10,1,2,3)) should be(1)
  }
}
