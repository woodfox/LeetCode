package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BuySellStockIITest extends FunSuite with ShouldMatchers {
  val b = new BuySellStockII

  test("should work") {
    b.maxProfit(Array(1)) should be(0)
    b.maxProfit(Array(1,2)) should be(1)
    b.maxProfit(Array(3,2)) should be(0)
    b.maxProfit(Array(3,2,1)) should be(0)
    b.maxProfit(Array(3,2,1,2)) should be(1)
    b.maxProfit(Array(3,2,1,2,3,4,3,2,1)) should be(3)
    b.maxProfit(Array(3,2,1,1,1)) should be(0)
    b.maxProfit(Array(3,2,1,1,1,2,2,2)) should be(1)
    b.maxProfit(Array(1,3,2,4,5,6,3,4,7)) should be(10)
  }
}
