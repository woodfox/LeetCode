package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class UglyNumberIITest extends FunSuite with ShouldMatchers {
  val u = new UglyNumberII

  test("should work") {
    u.nthUglyNumber(1) should be(1)
    u.nthUglyNumber(2) should be(2)
    u.nthUglyNumber(3) should be(3)
    u.nthUglyNumber(4) should be(4)
    u.nthUglyNumber(10) should be(12)
    u.nthUglyNumber(11) should be(15)
    u.nthUglyNumber(12) should be(16)

    u.nthUglyNumber(1407) should be(536870912)
  }
}
