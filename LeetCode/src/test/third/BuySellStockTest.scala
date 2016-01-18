package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BuySellStockTest extends FunSuite with ShouldMatchers {
  val b = new BuySellStock

  test("should work") {
    b.maxProfit(Array(1)) should be(0)
    b.maxProfit(Array(1,2)) should be(1)
    b.maxProfit(Array(3,2)) should be(0)
    b.maxProfit(Array(3,2,4)) should be(2)
    b.maxProfit(Array(1,2,3,4)) should be(3)
    b.maxProfit(Array(1,2,3,4,3,2,5,7)) should be(6)
    b.maxProfit(Array(4,7,5,1,2,3)) should be(3)
    b.maxProfit(Array(4,7,5,1,2,3,4,3,2,5,7)) should be(6)
  }
}
