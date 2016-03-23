package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestSubstringWithTwoCharTest extends FunSuite with ShouldMatchers {
  val t = new LongestSubstringWithTwoChar

  test("should work") {
    t.longestWithTWoChar("") should be(0)
    t.longestWithTWoChar("a") should be(1)
    t.longestWithTWoChar("ab") should be(2)
    t.longestWithTWoChar("abc") should be(2)
    t.longestWithTWoChar("abcd") should be(2)
    t.longestWithTWoChar("abacd") should be(3)
    t.longestWithTWoChar("abaccaccd") should be(6)
    t.longestWithTWoChar("abcdedfg") should be(3)
    t.longestWithTWoChar("aaaaa") should be(5)
    t.longestWithTWoChar("aaaabb") should be(6)
    t.longestWithTWoChar("aaabbb") should be(6)
    t.longestWithTWoChar("aaabbbcccddd") should be(6)
    t.longestWithTWoChar("aabbccdd") should be(4)
    t.longestWithTWoChar("aabbaaccddcc") should be(6)
  }
}
