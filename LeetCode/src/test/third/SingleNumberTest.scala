package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SingleNumberTest extends FunSuite with ShouldMatchers {
  val s = new SingleNumber

  test("should work") {
    s.singleNumber(Array(3,2,4,5,2,3,5)) should be(4)
    s.singleNumber(Array(3,2,4,5,2,3,5,4,1)) should be(1)
    s.singleNumber(Array(3)) should be(3)
    s.singleNumber(Array(3,4,3)) should be(4)
    s.singleNumber(Array(3,4,3,4,2)) should be(2)
  }
}
