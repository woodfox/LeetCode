package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class StrobogrammaticNumberTest extends FunSuite with ShouldMatchers{
  test("should work") {
    val s = new StrobogrammaticNumber

    s.isStrobogrammatic("") should be(true)
    s.isStrobogrammatic("1") should be(true)
    s.isStrobogrammatic("8") should be(true)
    s.isStrobogrammatic("0") should be(true)
    s.isStrobogrammatic("6") should be(false)
    s.isStrobogrammatic("9") should be(false)
    s.isStrobogrammatic("69") should be(true)
    s.isStrobogrammatic("619") should be(true)
    s.isStrobogrammatic("609") should be(true)
    s.isStrobogrammatic("906") should be(true)
    s.isStrobogrammatic("19061") should be(true)
    s.isStrobogrammatic("19861") should be(true)
    s.isStrobogrammatic("99866") should be(true)
    s.isStrobogrammatic("89868") should be(true)
    s.isStrobogrammatic("89368") should be(false)
    s.isStrobogrammatic("39163") should be(false)
  }
}
