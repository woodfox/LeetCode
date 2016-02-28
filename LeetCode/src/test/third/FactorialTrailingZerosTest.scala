package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FactorialTrailingZerosTest extends FunSuite with ShouldMatchers {
  val f = new FactorialTrailingZeros

  test("should work") {
    f.trailingZeroes(3) should be(0)
    f.trailingZeroes(7) should be(1)
    f.trailingZeroes(12) should be(2)
    f.trailingZeroes(15) should be(3)
    f.trailingZeroes(16) should be(3)
    f.trailingZeroes(52) should be(12)
    f.trailingZeroes(99) should be(22)
  }
}
