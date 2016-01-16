package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SqrtTest extends FunSuite with ShouldMatchers {
  val sqrt = new Sqrt()

  test("should calculate sqrt root"){
    sqrt.mySqrt(0) should be(0)
    sqrt.mySqrt(1) should be(1)
    sqrt.mySqrt(2) should be(1)
    sqrt.mySqrt(3) should be(1)
    sqrt.mySqrt(4) should be(2)
    sqrt.mySqrt(6) should be(2)
    sqrt.mySqrt(8) should be(2)
    sqrt.mySqrt(9) should be(3)
    sqrt.mySqrt(16) should be(4)
    sqrt.mySqrt(24) should be(4)
    sqrt.mySqrt(25) should be(5)
    sqrt.mySqrt(144) should be(12)
  }
}
