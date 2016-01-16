package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestPalindromeSubstringTest extends FunSuite with ShouldMatchers {
  val instance = new LongestPalindromeSubstring

  test("") {
    instance.longestPalindrome("") should be("")
    instance.longestPalindrome("a") should be("a")
    instance.longestPalindrome("ab") should be("a")
    instance.longestPalindrome("aba") should be("aba")
    instance.longestPalindrome("aaa") should be("aaa")
    instance.longestPalindrome("aa") should be("aa")
    instance.longestPalindrome("abcdedcfgh") should be("cdedc")
    instance.longestPalindrome("abcede") should be("ede")
    instance.longestPalindrome("aaaaaaabcdefghgfedcb") should be("bcdefghgfedcb")
    instance.longestPalindrome("abcdefghijklmn") should be("a")
    instance.longestPalindrome("zzbbzzbbz") should be("zbbzzbbz")
  }
}
