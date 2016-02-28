package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CoinChangeTest extends FunSuite with ShouldMatchers {
  val t = new CoinChange

  test("should work") {
    t.coinChange(Array(2,1), 3) should be(2)
    t.coinChange(Array(1,4,6), 8) should be(2)
    t.coinChange(Array(186,419,83,408), 6249) should be(20)
    t.coinChange(Array(389,46,222,352,4,250), 5343) should be(16)
    t.coinChange(Array(176,6,366,357,484,226,1,104,160,331), 5557) should be(13)
  }
}
