package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class SubSetIITest extends FunSuite with ShouldMatchers with ListHelper {
  val s = new SubSetII

  test("should work") {
    println("zzzzzz: " + s.subsetsWithDup(Array(1, 2, 3)))
    convertJavaListToSet(s.subsetsWithDup(Array(1))) should be(Set(List(), List(1)))
    convertJavaListToSet(s.subsetsWithDup(Array(1, 1))) should be(Set(List(), List(1), List(1,1)))
    convertJavaListToSet(s.subsetsWithDup(Array(2, 1, 1))) should be(Set(List(), List(1), List(2), List(1,1), List(1,2), List(1,1,2)))
    convertJavaListToSet(s.subsetsWithDup(Array(3, 2, 1))) should be(Set(
      List(), List(1), List(2), List(3), List(1,2), List(1,3), List(2,3), List(1,2,3)))
    convertJavaListToSet(s.subsetsWithDup(Array(1, 2, 3))) should be(Set(
      List(), List(1), List(2), List(3), List(3), List(1,2), List(1,3), List(2,3), List(1,2,3)))
  }
}
