package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BurstBallonsTest extends FunSuite with ShouldMatchers {
  val t = new BurstBallons

  test("should work") {
    t.maxCoins(Array(3,1,5,8)) should be(167)
    t.maxCoins(Array(3,1,5)) should be(35)
    t.maxCoins(Array(1,2,3,4)) should be(40)
  }

  test("memo version should work") {
    t.maxCoins_cache(Array(3,1,5,8)) should be(167)
    t.maxCoins_cache(Array(3,1,5)) should be(35)
    t.maxCoins_cache(Array(1,2,3,4)) should be(40)
  }
}
