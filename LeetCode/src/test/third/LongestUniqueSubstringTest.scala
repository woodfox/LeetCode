package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestUniqueSubstringTest extends FunSuite with ShouldMatchers {
  val instance = new LongestUniqueSubstring

  test("it should return max length of substring with unique characters") {
    instance.lengthOfLongestSubstring("") should be(0)
    instance.lengthOfLongestSubstring("a") should be(1)
    instance.lengthOfLongestSubstring("ab") should be(2)
    instance.lengthOfLongestSubstring("aaa") should be(1)
    instance.lengthOfLongestSubstring("abcabcbb") should be(3)
    instance.lengthOfLongestSubstring("abccbad") should be(4)
    instance.lengthOfLongestSubstring("abcdebfg") should be(6)
    instance.lengthOfLongestSubstring("abbcdef") should be(5)
    instance.lengthOfLongestSubstring("ababcdcdefghabijklmn") should be(14)
  }
}
