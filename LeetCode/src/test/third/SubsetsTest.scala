package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class SubsetsTest extends FunSuite with ShouldMatchers with ListHelper {
  val s = new Subsets

  test("should work"){
    convertJavaListToSet(s.subsets(Array(1,2))) should be(Set(List(), List(1), List(2), List(1,2)))
    convertJavaListToSet(s.subsets(Array(2,1))) should be(Set(List(), List(1), List(2), List(1,2)))
    convertJavaListToSet(s.subsets(Array(1,2,3))) should be(Set(List(), List(1), List(2), List(3), List(1,2), List(1,3), List(2,3), List(1,2,3)))
    convertJavaListToSet(s.subsets(Array(3,2,1))) should be(Set(List(), List(1), List(2), List(3), List(1,2), List(1,3), List(2,3), List(1,2,3)))
  }
}
