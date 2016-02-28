package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PaintFenceTest extends FunSuite with ShouldMatchers {
  val p = new PaintFence

  test("should work") {
    p.numWays(1, 1) should be(1)
    p.numWays(1, 2) should be(2)
    p.numWays(2, 2) should be(4)
    p.numWays(3, 2) should be(6)
  }
}
