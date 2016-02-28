package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class NumberOfIslandsIITest extends FunSuite with ShouldMatchers {
  val t = new NumberOfIslandsII

  test("should work") {
    t.numIslands2(3, 3, List(Array(0,0),Array(0,1),Array(1,2),Array(2,1))).toList should be(List(1,1,2,3))
    t.numIslands2(3, 4, List(Array(0,0),Array(0,1),Array(0,2),Array(2,0),Array(2,1),Array(1,0))).toList should be(List(1,1,1,2,2,1))
    t.numIslands2(3, 3, List(Array(0,1),Array(1,0),Array(2,1),Array(1,2),Array(1,1))).toList should be(List(1,2,3,4,1))
  }

  test("disjoint version should work") {
    t.numIslands2_faster(3, 3, List(Array(0,0),Array(0,1),Array(1,2),Array(2,1))).toList should be(List(1,1,2,3))
    t.numIslands2_faster(3, 4, List(Array(0,0),Array(0,1),Array(0,2),Array(2,0),Array(2,1),Array(1,0))).toList should be(List(1,1,1,2,2,1))
    t.numIslands2_faster(3, 3, List(Array(0,1),Array(1,0),Array(2,1),Array(1,2),Array(1,1))).toList should be(List(1,2,3,4,1))
  }
}
