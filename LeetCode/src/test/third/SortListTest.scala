package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class SortListTest extends FunSuite with ShouldMatchers with ListHelper {
  val s = new SortList

  test("should work") {
    s.sortList(createList(Nil)) should be(createList(Nil))
    s.sortList(createList(List(1))) should be(createList(List(1)))
    s.sortList(createList(List(1,2,3,4))) should be(createList(List(1,2,3,4)))
    s.sortList(createList(List(4,3,2,1))) should be(createList(List(1,2,3,4)))
    s.sortList(createList(List(3,6,4,1,9,0,7))) should be(createList(List(0,1,3,4,6,7,9)))
  }
}
