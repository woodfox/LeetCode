package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class TriangleTest extends FunSuite with ShouldMatchers with ListHelper {
  val t = new Triangle

  test("should work") {
    t.minimumTotal(convertScalaList(List(List(1), List(2,3)))) should be(3)
    t.minimumTotal(convertScalaList(List(List(1), List(2,3), List(4,5,6)))) should be(7)
    t.minimumTotal(convertScalaList(List(List(1), List(6,3), List(2,9,6)))) should be(9)
  }
}
