package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PalindromePartitionIITest extends FunSuite with ShouldMatchers {
  val p = new PalindromePartitionII

  test("should work") {
    p.minCut("") should be(0)
    p.minCut("a") should be(0)
    p.minCut("aa") should be(0)
    p.minCut("aaa") should be(0)
    p.minCut("aba") should be(0)
    p.minCut("abba") should be(0)
    p.minCut("abcba") should be(0)
    p.minCut("ab") should be(1)
    p.minCut("abc") should be(2)
    p.minCut("abcb") should be(1)
    p.minCut("abcba") should be(0)
    p.minCut("abcda") should be(4)
  }
}
