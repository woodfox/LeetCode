package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BuySellStockWithColldownTest extends FunSuite with ShouldMatchers {
  val t = new BuySellStockWithColldown

  test("should work") {
    t.maxProfit(Array(6,1,3,2,4,7)) should be(6)
    t.maxProfit(Array(3,2,6,5,0,3)) should be(7)
  }
}
