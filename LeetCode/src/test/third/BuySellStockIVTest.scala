package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BuySellStockIVTest extends FunSuite with ShouldMatchers {
  val b = new BuySellStockIV

  test("shoudl work") {
    b.maxProfit(0, Array(3)) should be(0)
    b.maxProfit(1, Array(3)) should be(0)
    b.maxProfit(1, Array(3,5)) should be(2)
    b.maxProfit(2, Array(3,5)) should be(2)
    b.maxProfit(3, Array(3,5)) should be(2)
    b.maxProfit(0, Array(3,5,1,3,6,9,3,5)) should be(0)
    b.maxProfit(1, Array(3,5,1,3,6,9,3,5)) should be(8)
    b.maxProfit(2, Array(3,5,1,3,6,9,3,6)) should be(11)
    b.maxProfit(3, Array(3,5,1,3,6,9,3,6)) should be(13)
    b.maxProfit(4, Array(3,5,1,3,6,9,3,6)) should be(13)
    b.maxProfit(10, Array(3,5,1,3,6,9,3,6)) should be(13)

    b.maxProfit(1, Array(1,3,6,9,10,12)) should be(11)
    b.maxProfit(2, Array(1,3,6,9,10,12)) should be(11)
    b.maxProfit(5, Array(1,3,6,9,10,12)) should be(11)
    b.maxProfit(2, Array(1,2,4,2,5,7,2,4,9,0)) should be(13)

    b.maxProfit(500, Array(1,3,6,9,10,12)) should be(11)
  }
}
