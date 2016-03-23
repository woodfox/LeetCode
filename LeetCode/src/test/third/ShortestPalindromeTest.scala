package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ShortestPalindromeTest extends FunSuite with ShouldMatchers {
  val t = new ShortestPalindrome
  test("should work"){
    t.shortestPalindrome("abacd") should be("dcabacd")
    t.shortestPalindrome("bbaba") should be("ababbaba")

    t.calcPrefix("ababb") should be(Array(0,0,1,2,0))
  }
}
