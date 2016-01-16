package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ReverseIntegerTest extends FunSuite with ShouldMatchers {
  val instance = new ReverseInteger

  test("ReverseInteger should reverse the integer") {
    instance.reverse(0) should be(0)
    instance.reverse(1) should be(1)
    instance.reverse(12) should be(21)
    instance.reverse(120) should be(21)
    instance.reverse(123456) should be(654321)
    instance.reverse(-123456) should be(-654321)
    instance.reverse(-1234560) should be(-654321)
    instance.reverse(1534236469) should be(0)
    instance.reverse(-1534236469) should be(0)
  }
}
