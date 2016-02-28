package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SwapArraysTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val s = new SwapArrays

    s.swap(Array(1,2,3,4,5,6,7), 0, 0, 6) should be(Array(2,3,4,5,6,7,1))
    s.swap(Array(1,2,3,4,5,6,7), 0, 1, 6) should be(Array(3,4,5,6,7,1,2))
    s.swap(Array(1,2,3,4,5,6,7), 0, 2, 6) should be(Array(4,5,6,7,1,2,3))
    s.swap(Array(1,2,3,4,5,6,7), 0, 3, 6) should be(Array(5,6,7,1,2,3,4))
    s.swap(Array(1,2,3,4,5,6,7), 0, 4, 6) should be(Array(6,7,1,2,3,4,5))
    s.swap(Array(1,2,3,4,5,6,7), 0, 5, 6) should be(Array(7,1,2,3,4,5,6))

    s.swap(Array(1,2,3,4,5,6,7), 1, 3, 5) should be(Array(1,5,6,2,3,4,7))
    s.swap(Array(1,2,3,4,5,6,7), 1, 3, 4) should be(Array(1,5,2,3,4,6,7))
  }
}
