package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ThreeSumSmallerTest extends FunSuite with ShouldMatchers {
  val t = new ThreeSumSmaller

  test("should work") {
    t.threeSumSmaller(Array(-2,0,1,3), -1) should be(0)
    t.threeSumSmaller(Array(-2,0,1,3), 1) should be(1)
    t.threeSumSmaller(Array(-2,0,1,3), 2) should be(2)
    t.threeSumSmaller(Array(-2,0,1,3), 3) should be(3)
    t.threeSumSmaller(Array(-2,0,1,3), 4) should be(3)
    t.threeSumSmaller(Array(-2,0,1,3), 5) should be(4)
    t.threeSumSmaller(Array(-2,0,1,3,2), 2) should be(4)
    t.threeSumSmaller(Array(-2,0,1,3,2), 3) should be(5)
    t.threeSumSmaller(Array(-2,0,1,3,2), 4) should be(7)
    t.threeSumSmaller(Array(-2,0,1,3,2), 5) should be(8)
    t.threeSumSmaller(Array(-2,0,1,3,2), 6) should be(9)
    t.threeSumSmaller(Array(-2,0,1,3,2), 7) should be(10)
  }

  test("slower version should work") {
    t.threeSumSmaller_slow(Array(-2,0,1,3), -1) should be(0)
    t.threeSumSmaller_slow(Array(-2,0,1,3), 1) should be(1)
    t.threeSumSmaller_slow(Array(-2,0,1,3), 2) should be(2)
    t.threeSumSmaller_slow(Array(-2,0,1,3), 3) should be(3)
    t.threeSumSmaller_slow(Array(-2,0,1,3), 4) should be(3)
    t.threeSumSmaller_slow(Array(-2,0,1,3), 5) should be(4)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 2) should be(4)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 3) should be(5)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 4) should be(7)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 5) should be(8)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 6) should be(9)
    t.threeSumSmaller_slow(Array(-2,0,1,3,2), 7) should be(10)
  }
}
