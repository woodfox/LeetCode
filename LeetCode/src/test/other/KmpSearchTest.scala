package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class KmpSearchTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val k = new KmpSearch

    k.search("abcabcdabce", "abcd") should be(3)
    k.search("aaaabcabcdabcaebbb", "abcabcdabcae") should be(3)
    k.search("abcabcdabce", "abcde") should be(-1)
    k.search("abcabcdabce", "abce") should be(7)
    k.search("ababcdabce", "abcd") should be(2)
  }

  test("calcNext should be same as calcNextPrefix") {
    val k = new KmpSearch

    k.calcNext("abcdabd") should be(k.calcNextByPrefix("abcdabd"))
    k.calcNext("abcabcdabcae") should be(k.calcNextByPrefix("abcabcdabcae"))
    k.calcNext("abababab") should be(k.calcNextByPrefix("abababab"))
    k.calcNext("aaaaabbbbbaaaa") should be(k.calcNextByPrefix("aaaaabbbbbaaaa"))
    k.calcNext("acacacacaca") should be(k.calcNextByPrefix("acacacacaca"))
    k.calcNext("ababcababdababe") should be(k.calcNextByPrefix("ababcababdababe"))
  }
}
