package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class SkylinePointsTest extends FunSuite with ShouldMatchers {
  val s = new SkylinePoints
  test("should work") {
    s.getSkyline(Array(Array(1,2,4))).toList.map(_.toList) should be(List(List(1,4), List(2,0)))
    s.getSkyline(Array(Array(1,2,4),Array(1,3,5))).toList.map(_.toList) should be(List(List(1,5), List(3,0)))
    s.getSkyline(Array(Array(0,2,3),Array(2,5,3))).toList.map(_.toList) should be(List(List(0,3), List(5,0)))

    s.getSkyline(Array(Array(1,5,4), Array(2,3,6), Array(3,4,7)))
      .toList.map(_.toList) should be(List(List(1,4), List(2,6),List(3,7),List(4,4),List(5,0)))
    s.getSkyline(Array(Array(2,9,10), Array(3,7,15), Array(5,12,12),Array(15,20,10),Array(19,24,8)))
      .toList.map(_.toList) should be(List(List(2,10),List(3,15),List(7,12),List(12,0),List(15,10),List(20,8),List(24,0)))
  }
}
