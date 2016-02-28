package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FindPeakElementTest extends FunSuite with ShouldMatchers {
  val f = new FindPeakElement

  test("should work") {
    f.findPeakElement(Array(1)) should be(0)
    f.findPeakElement(Array(1,2)) should be(1)
    f.findPeakElement(Array(1,2,3)) should be(2)
    f.findPeakElement(Array(1,2,3,1)) should be(2)
    f.findPeakElement(Array(1,2,3,1,2)) should be(2)
    f.findPeakElement(Array(4,3,2,1)) should be(0)
    f.findPeakElement(Array(4,3,2,1,2,3,4)) should be(0)
  }
}
