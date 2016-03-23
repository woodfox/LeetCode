package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

import scala.collection.JavaConversions._

class BuildingOutlinesTest extends FunSuite with ShouldMatchers with ListHelper {
  val t = new BuildingOutlines

  test("should work") {
    t.buildingOutline(Array(Array(1,3,3),Array(2,4,4),Array(5,6,1))).map(_.toList).toList should
      be(List(List(1,2,3),List(2,4,4),List(5,6,1)))
    t.buildingOutline(Array(Array(1,5,9),Array(2,10,3),Array(7,14,9),Array(12,18,3),Array(16,20,9),Array(20,25,19),Array(22,31,7))).map(_.toList).toList should
      be(List(List(1,5,9),List(5,7,3),List(7,14,9),List(14,16,3),List(16,20,9),List(20,25,19),List(25,31,7)))

  }
}
