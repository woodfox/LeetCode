package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class DivideTwoIntegerTest extends FunSuite with ShouldMatchers {
  val d = new DivideTwoInteger

  test("should dividend two integers") {
    d.divide(2, 0) should be(Integer.MAX_VALUE)
    d.divide(0, 1) should be(0)
    d.divide(2, 1) should be(2)
    d.divide(2, 2) should be(1)
    d.divide(2, 3) should be(0)
    d.divide(4, 3) should be(1)
    d.divide(6, 3) should be(2)
    d.divide(7, 3) should be(2)
    d.divide(9, 3) should be(3)
    d.divide(99999, 1) should be(99999)
    d.divide(99999, 3) should be(33333)
    d.divide(-1010369383, -2147483648) should be(0)
    d.divide(Integer.MAX_VALUE, 1) should be(Integer.MAX_VALUE)
    d.divide(Integer.MIN_VALUE, 1) should be(Integer.MIN_VALUE)
  }

}
