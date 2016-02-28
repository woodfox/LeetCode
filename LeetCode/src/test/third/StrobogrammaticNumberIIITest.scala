package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class StrobogrammaticNumberIIITest extends FunSuite with ShouldMatchers {
  test("should work") {
    val s = new StrobogrammaticNumberIII
    s.strobogrammaticInRange("50", "100") should be(3)
    s.strobogrammaticInRange("50", "90") should be(2)
    s.strobogrammaticInRange("50", "88") should be(2)
    s.strobogrammaticInRange("50", "87") should be(1)
    s.strobogrammaticInRange("10", "87") should be(2)
    s.strobogrammaticInRange("1", "87") should be(6)
  }
}
