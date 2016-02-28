package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PaintHouseIITest extends FunSuite with ShouldMatchers {
  val p = new PaintHouseII

  test("should work") {
    p.minCost(Array()) should be(0)
    p.minCost(Array(Array(3,2,5))) should be(2)
    p.minCost(Array(Array(3,2,5),Array(6,3,7))) should be(6)
    p.minCost(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2))) should be(8)
    p.minCost(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2),Array(15,5,4))) should be(13)

    p.minCost(Array(Array(3,2,5,4))) should be(2)
    p.minCost(Array(Array(3,2,5,4),Array(2,3,7,5))) should be(4)
    p.minCost(Array(Array(3,2,5,4),Array(2,3,7,5),Array(6,5,4,8))) should be(8)
    p.minCost(Array(Array(3,2,5,4),Array(2,3,7,5),Array(6,5,4,8),Array(11,2,3,6))) should be(10)
  }
}
