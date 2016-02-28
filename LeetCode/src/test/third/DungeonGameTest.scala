package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class DungeonGameTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val d = new DungeonGame

    d.calculateMinimumHP(Array(Array(0,0,0), Array(1,1,-1))) should be(1)

    d.calculateMinimumHP(Array(Array(-2,-3,3))) should be(6)
    d.calculateMinimumHP(Array(Array(-2,-3,3),Array(5,-10,1))) should be(6)
    d.calculateMinimumHP(Array(Array(-2,-3,3),Array(5,10,-5))) should be(3)
    d.calculateMinimumHP(Array(Array(-2,-3,3),Array(5,-10,-5))) should be(8)
    d.calculateMinimumHP(Array(Array(-2,-3,3),Array(-5,-10,1),Array(10,30,-5))) should be(7)
    d.calculateMinimumHP(Array(Array(-2,-3,3),Array(-5,-10,-8),Array(10,30,-5))) should be(8)
  }
}
