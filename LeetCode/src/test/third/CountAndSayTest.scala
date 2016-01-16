package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CountAndSayTest extends FunSuite with ShouldMatchers {
  val c = new CountAndSay

  test("Should say the correct string"){
    c.countAndSay(1) should be("1")
    c.countAndSay(2) should be("11")
    c.countAndSay(3) should be("21")
    c.countAndSay(4) should be("1211")
    c.countAndSay(5) should be("111221")
    c.countAndSay(6) should be("312211")
    c.countAndSay(7) should be("13112221")
    c.countAndSay(8) should be("1113213211")
    c.countAndSay(9) should be("31131211131221")
  }
}
