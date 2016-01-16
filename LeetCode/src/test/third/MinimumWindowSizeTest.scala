package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MinimumWindowSizeTest extends FunSuite with ShouldMatchers {
  val m = new MinimumWindowSize

  test("should work") {
    m.minWindow("a", "b") should be("")
    m.minWindow("ab", "b") should be("b")
    m.minWindow("bcdadb", "ab") should be("adb")
    m.minWindow("bcdadba", "ab") should be("ba")
    m.minWindow("bcdadb", "abc") should be("bcda")
    m.minWindow("bcdadb", "abb") should be("bcdadb")
    m.minWindow("bcdadb", "abe") should be("")
    m.minWindow("adbdeabcfb", "bacb") should be("abcfb")
    m.minWindow("ADOBECODEBANC", "ABC") should be("BANC")
  }
}
