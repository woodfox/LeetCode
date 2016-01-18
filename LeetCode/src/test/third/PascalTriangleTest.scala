package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class PascalTriangleTest extends FunSuite with ShouldMatchers with ListHelper {
  val p = new PascalTriangle

  test("should work") {
    convertJavaList(p.generate(1)) should be(List(List(1)))
    convertJavaList(p.generate(2)) should be(List(List(1), List(1,1)))
    convertJavaList(p.generate(3)) should be(List(List(1), List(1,1), List(1,2,1)))
    convertJavaList(p.generate(4)) should be(List(List(1), List(1,1), List(1,2,1), List(1,3,3,1)))
    convertJavaList(p.generate(5)) should be(List(List(1), List(1,1), List(1,2,1), List(1,3,3,1), List(1,4,6,4,1)))
  }
}
