package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PalindromeNumberTest extends FunSuite with ShouldMatchers {
  val instance = new PalindromeNumber

  test("should check if number is palindrome"){
    instance.isPalindrome(1) should be(true)
    instance.isPalindrome(-1) should be(false)
    instance.isPalindrome(12) should be(false)
    instance.isPalindrome(10) should be(false)
    instance.isPalindrome(121) should be(true)
    instance.isPalindrome(-121) should be(false)
    instance.isPalindrome(1221) should be(true)
    instance.isPalindrome(11111) should be(true)
    instance.isPalindrome(1000021) should be(false)
    instance.isPalindrome(+11111) should be(true)
    instance.isPalindrome(-2147447412) should be(false)
    instance.isPalindrome(1874994781) should be(true)
  }
}
