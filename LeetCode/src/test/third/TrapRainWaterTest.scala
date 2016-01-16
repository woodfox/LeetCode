package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class TrapRainWaterTest extends FunSuite with ShouldMatchers {
  val t = new TrapRainWater

  test("should calculate max water") {
    t.trap(Array(0)) should be(0)
    t.trap(Array(4,4,4,4,4,4,4,4)) should be(0)
    t.trap(Array(4,2,3)) should be(1)
    t.trap(Array(0,1,2,3,4)) should be(0)
    t.trap(Array(6,5,4,3,2,1,0)) should be(0)
    t.trap(Array(0,1,2,3,4,3,5)) should be(1)
    t.trap(Array(0,1,0,1,0,1,0)) should be(2)
    t.trap(Array(6,5,4,3,2,1,0,3)) should be(6)
    t.trap(Array(0,1,0,2,1,0,1,3,2,1,2,1)) should be(6)
  }
}
