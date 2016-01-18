package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BuySellStockIIITest extends FunSuite with ShouldMatchers {
  val b = new BuySellStockIII

  test("should work") {
    b.maxProfit(Array(1)) should be(0)
    b.maxProfit(Array(1,4)) should be(3)
    b.maxProfit(Array(1,2,3,4)) should be(3)
    b.maxProfit(Array(1,2,3,2,1,4,5,3,7)) should be(8)
    b.maxProfit(Array(1,6,2,8,3,4,9)) should be(13)
  }
}
