package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WildcardMatchTest extends FunSuite with ShouldMatchers {
  val w = new WildcardMatch

  test("should check if string matches pattern"){
    w.isMatch("", "a") should be(false)
    w.isMatch("a", "a") should be(true)
    w.isMatch("ab", "a") should be(false)
    w.isMatch("ab", "a*") should be(true)
    w.isMatch("ab", "ac") should be(false)
    w.isMatch("abc", "a*") should be(true)
    w.isMatch("abc", "a?") should be(false)
    w.isMatch("abc", "a?c") should be(true)
    w.isMatch("abc", "a*c") should be(true)
    w.isMatch("abc", "a*******") should be(true)
    w.isMatch("abc", "a??") should be(true)
    w.isMatch("abc", "a???") should be(false)
    w.isMatch("abc", "???") should be(true)
    w.isMatch("abc", "*********") should be(true)
    w.isMatch("abc", "") should be(false)
    w.isMatch("abc", "*") should be(true)
    w.isMatch("abc", "c****") should be(false)
    w.isMatch("abc", "****c") should be(true)
    w.isMatch("abc", "?") should be(false)
    w.isMatch("abc", "??") should be(false)
    w.isMatch("abcabc", "*abc") should be(true)
    w.isMatch("abcabc", "abc*") should be(true)
    w.isMatch("abcabc", "abc*abc") should be(true)
    w.isMatch("abcabc", "abc*ab") should be(false)
    w.isMatch("abcabc", "*??") should be(true)
    w.isMatch("abcabc", "??*") should be(true)
    w.isMatch("b", "?*?") should be(false)
    w.isMatch("bb", "?*?") should be(true)
    w.isMatch("abb", "?*?") should be(true)
    w.isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
    "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb") should be(false)
  }
}
