package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CountPrimesTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val c = new CountPrimes
    c.countPrimes(1) should be(0)
    c.countPrimes(2) should be(0)
    c.countPrimes(3) should be(1)
    c.countPrimes(4) should be(2)
    c.countPrimes(5) should be(2)
    c.countPrimes(6) should be(3)
    c.countPrimes(7) should be(3)
    c.countPrimes(8) should be(4)
    c.countPrimes(9) should be(4)
    c.countPrimes(10) should be(4)
    c.countPrimes(11) should be(4)
    c.countPrimes(12) should be(5)
    c.countPrimes(13) should be(5)
    c.countPrimes(14) should be(6)
    c.countPrimes(15) should be(6)
    c.countPrimes(16) should be(6)
    c.countPrimes(17) should be(6)
    c.countPrimes(18) should be(7)
    c.countPrimes(19) should be(7)
    c.countPrimes(20) should be(8)
    c.countPrimes(21) should be(8)
    c.countPrimes(22) should be(8)
  }
}
