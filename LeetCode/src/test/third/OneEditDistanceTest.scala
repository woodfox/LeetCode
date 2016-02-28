package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class OneEditDistanceTest extends FunSuite with ShouldMatchers {
  val o = new OneEditDistance

  test("should work") {
    o.isOneEditDistance("", "") should be(true)
    o.isOneEditDistance("", "a") should be(true)
    o.isOneEditDistance("a", "") should be(true)
    o.isOneEditDistance("a", "a") should be(true)
    o.isOneEditDistance("a", "ab") should be(true)
    o.isOneEditDistance("ab", "a") should be(true)
    o.isOneEditDistance("ab", "ab") should be(true)
    o.isOneEditDistance("ab", "abc") should be(true)
    o.isOneEditDistance("ac", "abc") should be(true)
    o.isOneEditDistance("bc", "abc") should be(true)
    o.isOneEditDistance("bc", "c") should be(true)
    o.isOneEditDistance("cb", "c") should be(true)
    o.isOneEditDistance("cb", "ac") should be(false)
    o.isOneEditDistance("cb", "acc") should be(false)
    o.isOneEditDistance("cb", "acd") should be(false)
    o.isOneEditDistance("cb", "acbb") should be(false)
    o.isOneEditDistance("acddb", "acbb") should be(false)
    o.isOneEditDistance("acbbbbbb", "acbb") should be(false)
  }
}
