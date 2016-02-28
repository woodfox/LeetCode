package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MajorityElementTest extends FunSuite with ShouldMatchers {
  val m = new MajorityElement

  test("should work") {
    m.majorityElement(Array()) should be(-1)
    m.majorityElement(Array(1)) should be(1)
    m.majorityElement(Array(1,2)) should be(-1)
    m.majorityElement(Array(1,2,1)) should be(1)
    m.majorityElement(Array(1,2,1,1)) should be(1)
    m.majorityElement(Array(1,2,1,3,1)) should be(1)
  }
}
