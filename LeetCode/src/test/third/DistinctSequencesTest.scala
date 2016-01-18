package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class DistinctSequencesTest extends FunSuite with ShouldMatchers {
  val d = new DistinctSequences

  test("should work") {
    d.numDistinct("rabbbit", "rabbit") should be(3)
    d.numDistinct("rabbit", "rabbit") should be(1)
    d.numDistinct("rabbit", "rabit") should be(2)
    d.numDistinct("rait", "rabit") should be(0)
    d.numDistinct("rabit", "rabit") should be(1)
    d.numDistinct("rabit", "rabitt") should be(0)
    d.numDistinct("aab", "a") should be(2)
    d.numDistinct("aab", "aa") should be(1)
    d.numDistinct("aab", "aab") should be(1)
    d.numDistinct("aab", "aabc") should be(0)
    d.numDistinct("aaba", "ab") should be(2)
  }
}
