package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.PointHelper

class MaxPointsTest extends FunSuite with ShouldMatchers with PointHelper {
  val m = new MaxPoints

  test("should work") {
    m.maxPoints(createPoints(List()).toArray) should be(0)
    m.maxPoints(createPoints(List((1,1))).toArray) should be(1)
    m.maxPoints(createPoints(List((1,1),(1,1))).toArray) should be(2)
    m.maxPoints(createPoints(List((1,1), (1,2))).toArray) should be(2)
    m.maxPoints(createPoints(List((1,1), (1,2),(1,1))).toArray) should be(3)
    m.maxPoints(createPoints(List((1,1), (1,2),(1,3),(1,4))).toArray) should be(4)
    m.maxPoints(createPoints(List((1,1), (1,2),(2,2),(3,3))).toArray) should be(3)
    m.maxPoints(createPoints(List((1,1), (0,2),(1,3),(2,2),(3,1))).toArray) should be(3)
  }
}
