package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class AverageInWindowTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val t = new AverageInWindow(3)
    t.next(10) should be(10)
    t.next(12) should be(11)
    t.next(18) should be(40/3)
    t.next(3) should be(11)
    t.next(0) should be(7)
    t.next(3) should be(2)
    t.next(1) should be(4/3)
  }

  test("window size 1 should work") {
    val t = new AverageInWindow(1)
    t.next(10) should be(10)
    t.next(12) should be(12)
    t.next(1) should be(1)
  }
}
