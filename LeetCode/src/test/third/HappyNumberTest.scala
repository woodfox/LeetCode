package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class HappyNumberTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val h = new HappyNumber

    h.isHappy(1) should be(true)
    h.isHappy(19) should be(true)
    h.isHappy(2) should be(false)
    h.isHappy(0) should be(false)
  }
}
