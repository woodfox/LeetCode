package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RegularExpressionMatchTest extends FunSuite with ShouldMatchers {
  val instance = new RegularExpressionMatch
  
  test("should match string correctly"){
    instance.isMatch(null, "a") should be(false)
    instance.isMatch("a",null) should be(false)
    instance.isMatch("aa","a") should be(false)
    instance.isMatch("aa","aa") should be(true)
    instance.isMatch("aaa","aa") should be(false)
    instance.isMatch("aa", "a*") should be(true)
    instance.isMatch("aa", ".*") should be(true)
    instance.isMatch("ab", ".*") should be(true)
    instance.isMatch("aab", "c*a*b") should be(true)
    instance.isMatch("a", "") should be(false)
    instance.isMatch("", "a") should be(false)
    instance.isMatch("aaa", "a*") should be(true)
    instance.isMatch("aaa", "b*") should be(false)
    instance.isMatch("aaabbbccc", "a*b*c*") should be(true)
    instance.isMatch("aaabbbccc", "a*bc*") should be(false)
    instance.isMatch("aaaccc", "a*c*") should be(true)
    instance.isMatch("aaccc", "a*b*c*") should be(true)
    instance.isMatch("cccccccccc", "a*b*c*") should be(true)
    instance.isMatch("aabbbcccddd", ".*.*.*") should be(true)
    instance.isMatch("ddddd", "a*b*c*") should be(false)
  }
}
