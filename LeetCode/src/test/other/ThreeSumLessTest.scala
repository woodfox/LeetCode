package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ThreeSumLessTest extends FunSuite with ShouldMatchers {
  val t = new ThreeSumLess

  test("should work") {
    t.threeSumLess(Array(1,2), 5) should be(0)
    t.threeSumLess(Array(1,2,3), 5) should be(0)
    t.threeSumLess(Array(1,2,3), 6) should be(0)
    t.threeSumLess(Array(1,2,3), 6) should be(0)
    t.threeSumLess(Array(4,1,2,3), 7) should be(1)
    t.threeSumLess(Array(4,1,2,3), 8) should be(2)
    t.threeSumLess(Array(4,1,2,3), 9) should be(3)
    t.threeSumLess(Array(4,1,2,3), 10) should be(4)
  }
}
