package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class CombinationsTest extends FunSuite with ShouldMatchers with ListHelper {
  val c = new Combinations

  test("should work"){
    convertJavaListToSet(c.combine(2, 1)) should be(Set(List(1), List(2)))
    convertJavaListToSet(c.combine(2, 2)) should be(Set(List(1,2)))
    convertJavaListToSet(c.combine(3, 2)) should be(Set(List(1,2),List(1,3),List(2,3)))
    convertJavaListToSet(c.combine(4, 2)) should be(Set(List(1,2),List(1,3),List(1,4),List(2,3),List(2,4),List(3,4)))
  }

}
