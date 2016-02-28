package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestSubstringWithTwoDiffCharsTest extends FunSuite with ShouldMatchers {
  val l = new LongestSubstringWithTwoDiffChars

  test("should work") {
    l.lengthOfLongestSubstringTwoDistinct("") should be(0)
    l.lengthOfLongestSubstringTwoDistinct("a") should be(1)
    l.lengthOfLongestSubstringTwoDistinct("ab") should be(2)
    l.lengthOfLongestSubstringTwoDistinct("abac") should be(3)
    l.lengthOfLongestSubstringTwoDistinct("abaccad") should be(4)
    l.lengthOfLongestSubstringTwoDistinct("abaccada") should be(4)
    l.lengthOfLongestSubstringTwoDistinct("dabaccada") should be(4)
    l.lengthOfLongestSubstringTwoDistinct("dabacacada") should be(5)
  }
}
