package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ValidPalindromeTest extends FunSuite with ShouldMatchers {
  val v = new ValidPalindrome

  test("should work") {
    v.isPalindrome("") should be(true)
    v.isPalindrome(" ") should be(true)
    v.isPalindrome("0P") should be(false)
    v.isPalindrome("10P") should be(false)
    v.isPalindrome("a a") should be(true)
    v.isPalindrome("a????b!!a! #") should be(true)
    v.isPalindrome("a0???9?b!9!0 a! #") should be(true)
    v.isPalindrome("ab  123   cdefg%fe!@dc321b!a!!#") should be(true)
  }
}
