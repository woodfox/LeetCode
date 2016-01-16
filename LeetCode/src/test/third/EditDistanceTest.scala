package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class EditDistanceTest extends FunSuite with ShouldMatchers {
  val e = new EditDistance

  test("should work"){
    e.minDistance("", "") should be(0)
    e.minDistance("", "a") should be(1)
    e.minDistance("", "ab") should be(2)
    e.minDistance("a", "") should be(1)
    e.minDistance("ab", "") should be(2)
    e.minDistance("a", "b") should be(1)
    e.minDistance("a", "bc") should be(2)
    e.minDistance("ab", "bc") should be(2)
    e.minDistance("abc", "b") should be(2)
    e.minDistance("abc", "bc") should be(1)
    e.minDistance("abc", "ac") should be(1)
    e.minDistance("abc", "cba") should be(2)
    e.minDistance("abcd", "abdc") should be(2)
  }
}
