package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ClimbingStairsTest extends FunSuite with ShouldMatchers {
  val c = new ClimbingStairs

  test("should work"){
    c.climbStairs(1) should be(1)
    c.climbStairs(2) should be(2)
    c.climbStairs(3) should be(3)
  }

}
