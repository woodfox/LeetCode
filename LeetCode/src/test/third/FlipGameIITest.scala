package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FlipGameIITest extends FunSuite with ShouldMatchers {
  val t = new FlipGameII
  test("should work") {
    t.canWin("+++") should be(true)
    t.canWin("++++") should be(true)
    t.canWin("+++++") should be(false)
    t.canWin("++++++") should be(true)
    t.canWin("+++++++") should be(true)
    t.canWin("++++++++") should be(true)
    t.canWin("+++++++++") should be(false)
    t.canWin("++++++++++") should be(true)
  }

  test("simple version should work") {
    t.canWin_simple("+++") should be(true)
    t.canWin_simple("++++") should be(true)
    t.canWin_simple("+++++") should be(false)
    t.canWin_simple("++++++") should be(true)
    t.canWin_simple("+++++++") should be(true)
    t.canWin_simple("++++++++") should be(true)
    t.canWin_simple("+++++++++") should be(false)
    t.canWin_simple("++++++++++") should be(true)
  }
}
