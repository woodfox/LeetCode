package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BitwiseOfNumberRangeTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val b = new BitwiseOfNumberRange

    b.rangeBitwiseAnd(0, 15) should be(0)
    b.rangeBitwiseAnd(1, 15) should be(0)
    b.rangeBitwiseAnd(1, 3) should be(0)
    b.rangeBitwiseAnd(2, 15) should be(0)
    b.rangeBitwiseAnd(8, 15) should be(8)
    b.rangeBitwiseAnd(9, 15) should be(8)
    b.rangeBitwiseAnd(10, 15) should be(8)
    b.rangeBitwiseAnd(11, 15) should be(8)
    b.rangeBitwiseAnd(12, 15) should be(12)
    b.rangeBitwiseAnd(3, 10) should be(0)
    b.rangeBitwiseAnd(5, 10) should be(0)
  }
}
