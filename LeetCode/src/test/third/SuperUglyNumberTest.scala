package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SuperUglyNumberTest extends FunSuite with ShouldMatchers {
  val t = new SuperUglyNumber
  test("nthSuperUglyNumber_lessSpace should work") {
    t.nthSuperUglyNumber_lessSpace(1, Array(3,5,7)) should be(1)
    t.nthSuperUglyNumber_lessSpace(2, Array(3,5,7)) should be(3)
    t.nthSuperUglyNumber_lessSpace(3, Array(3,5,7)) should be(5)
    t.nthSuperUglyNumber_lessSpace(4, Array(3,5,7)) should be(7)
    t.nthSuperUglyNumber_lessSpace(5, Array(3,5,7)) should be(9)
    t.nthSuperUglyNumber_lessSpace(6, Array(3,5,7)) should be(15)
  }
}
