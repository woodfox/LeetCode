package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestCommonSubStringTest extends FunSuite with ShouldMatchers {
  val t= new LongestCommonSubString

  test("should work") {
    t.longestCommonSubstr("a", "") should be("")
    t.longestCommonSubstr("", "") should be("")
    t.longestCommonSubstr("", "b") should be("")
    t.longestCommonSubstr("a", "b") should be("")
    t.longestCommonSubstr("a", "a") should be("a")
    t.longestCommonSubstr("ab", "ac") should be("a")
    t.longestCommonSubstr("ab", "ba") should be("b")
    t.longestCommonSubstr("abcd", "dbca") should be("bc")
    t.longestCommonSubstr("abcde", "cd") should be("cd")
    t.longestCommonSubstr("abcde", "bced") should be("bc")
    t.longestCommonSubstr("abcde", "de") should be("de")
    t.longestCommonSubstr("abcde", "edcbab") should be("ab")
  }

  test("less space version should work") {
    t.longestCommonSubstr_lessSpace("a", "") should be("")
    t.longestCommonSubstr_lessSpace("", "") should be("")
    t.longestCommonSubstr_lessSpace("", "b") should be("")
    t.longestCommonSubstr_lessSpace("a", "b") should be("")
    t.longestCommonSubstr_lessSpace("a", "a") should be("a")
    t.longestCommonSubstr_lessSpace("ab", "ac") should be("a")
    t.longestCommonSubstr_lessSpace("ab", "ba") should be("b")
    t.longestCommonSubstr_lessSpace("abcd", "dbca") should be("bc")
    t.longestCommonSubstr_lessSpace("abcde", "cd") should be("cd")
    t.longestCommonSubstr_lessSpace("abcde", "bced") should be("bc")
    t.longestCommonSubstr_lessSpace("abcde", "de") should be("de")
    t.longestCommonSubstr_lessSpace("abcde", "edcbab") should be("ab")
  }
}
