package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import other.Tries.MaxPointsInLine
import util.PointHelper

class MaxPointsInLineTest extends FunSuite with ShouldMatchers with PointHelper {
  val t = new MaxPointsInLine

  test("should work") {
//    t.maxPoints(Array()) should be(0)
//    t.maxPoints(Array(new Point(1,2),new Point(3,6),new Point(0,0),new Point(1,3))) should be(3)
//
//    t.maxPoints(createPoints(List((1,1))).toArray) should be(1)
//    t.maxPoints(createPoints(List((1,1),(1,1))).toArray) should be(2)
//    t.maxPoints(createPoints(List((1,1), (1,2))).toArray) should be(2)
//    t.maxPoints(createPoints(List((1,1), (1,2),(1,1))).toArray) should be(3)
//    t.maxPoints(createPoints(List((1,1), (1,2),(1,3),(1,4))).toArray) should be(4)
//    t.maxPoints(createPoints(List((1,1), (1,2),(2,2),(3,3))).toArray) should be(3)
//    t.maxPoints(createPoints(List((1,1), (0,2),(1,3),(2,2),(3,1))).toArray) should be(3)

    t.maxPoints(createPoints(List((0,-12),(5,2),(2,5),(0,-5),(1,5),(2,-2),(5,-4),(3,4),(-2,4),(-1,4),(0,-5),(0,-8),(-2,-1),(0,-11),(0,-9))).toArray) should be(6)
  }
}
