package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PaintHousesTest extends FunSuite with ShouldMatchers {
  val p = new PaintHouses
  test("should work") {
    p.minCost(Array()) should be(0)
    p.minCost(Array(Array(3,2,5))) should be(2)
    p.minCost(Array(Array(3,2,5))) should be(2)
    p.minCost(Array(Array(3,2,5),Array(6,3,7))) should be(6)
    p.minCost(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2))) should be(8)
    p.minCost(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2),Array(15,5,4))) should be(13)
  }

  test("enhanced version should work") {
    p.minCost_enhanced(Array()) should be(0)
    p.minCost_enhanced(Array(Array(3,2,5))) should be(2)
    p.minCost_enhanced(Array(Array(3,2,5))) should be(2)
    p.minCost_enhanced(Array(Array(3,2,5),Array(6,3,7))) should be(6)
    p.minCost_enhanced(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2))) should be(8)
    p.minCost_enhanced(Array(Array(3,2,5),Array(6,3,7),Array(8,10,2),Array(15,5,4))) should be(13)
  }
}
