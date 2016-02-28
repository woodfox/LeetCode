package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class HouseRobberTest extends FunSuite with ShouldMatchers {
  val h = new HouseRobber

  test("should work") {
    h.rob(Array(1)) should be(1)
    h.rob(Array(3,2)) should be(3)
    h.rob(Array(3,5,3)) should be(6)
    h.rob(Array(3,5,1)) should be(5)
    h.rob(Array(3,5,4,2)) should be(7)
    h.rob(Array(3,5,1,0,2)) should be(7)
    h.rob(Array(3,5,1,0,0,2)) should be(7)
    h.rob(Array(3,5,1,0,0,0,2)) should be(7)
  }
}
