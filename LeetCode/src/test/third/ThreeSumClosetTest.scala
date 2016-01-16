package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ThreeSumClosetTest extends FunSuite with ShouldMatchers {
  val t = new ThreeSumCloset

  test("should find the closed three sum") {
    t.threeSumClosest(Array(-1, 2), 1) should be(Integer.MAX_VALUE)
    t.threeSumClosest(Array(-1, 2, 1, -4), 1) should be(2)
    t.threeSumClosest(Array(-1, 2, 1, -4), 3) should be(2)
    t.threeSumClosest(Array(-1, 2, 1, -4), 5) should be(2)
    t.threeSumClosest(Array(-1, 2, 1, -4), 0) should be(-1)
    t.threeSumClosest(Array(-1, 2, 1, -4), -1) should be(-1)
    t.threeSumClosest(Array(-1, 2, 1, -4), -2) should be(-3)
    t.threeSumClosest(Array(-1, 2, 1, -4), -4) should be(-4)
    t.threeSumClosest(Array(-1, 2, 1, -4), -5) should be(-4)
  }
}
