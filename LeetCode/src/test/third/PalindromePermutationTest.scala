package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PalindromePermutationTest extends FunSuite with ShouldMatchers {
  val p = new PalindromePermutation

  test("should work") {
    p.canPermutePalindrome("code") should be(false)
    p.canPermutePalindrome("abc") should be(false)
    p.canPermutePalindrome("aba") should be(true)
    p.canPermutePalindrome("aa") should be(true)
    p.canPermutePalindrome("") should be(true)
    p.canPermutePalindrome("aabb") should be(true)
    p.canPermutePalindrome("aabbc") should be(true)
    p.canPermutePalindrome("aabbccd") should be(true)
    p.canPermutePalindrome("aabbccdde") should be(true)
  }
}
