package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ReverseWordsTest extends FunSuite with ShouldMatchers {
  val r = new ReverseWords

  test("should work") {
    r.reverseWords("") should be("")
    r.reverseWords("   ") should be("")
    r.reverseWords("I") should be("I")
    r.reverseWords("I  ") should be("I")
    r.reverseWords("I am") should be("am I")
    r.reverseWords("  I am  ") should be("am I")
    r.reverseWords("I am Jerry ") should be("Jerry am I")
    r.reverseWords("  I   am   Jerry    ") should be("Jerry am I")
  }
}
