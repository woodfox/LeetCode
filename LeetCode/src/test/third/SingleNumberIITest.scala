package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SingleNumberIITest extends FunSuite with ShouldMatchers {
  val s = new SingleNumberII

  test("should work") {
    s.singleNumber(Array(1,2,3,1,2,3,2,1)) should be(3)
    s.singleNumber(Array(1,2,3,1,2,3,2,1,3,4)) should be(4)
    s.singleNumber(Array(1,2,1,1)) should be(2)
    s.singleNumber(Array(1)) should be(1)
    s.singleNumber(Array(1,1)) should be(1)
    s.singleNumber(Array(1,1,2,2,1)) should be(2)
  }
}
