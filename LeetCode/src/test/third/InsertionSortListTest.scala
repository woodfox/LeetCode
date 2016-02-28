package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class InsertionSortListTest extends FunSuite with ShouldMatchers with ListHelper {
  val i = new InsertionSortList

  test("should work") {
    i.insertionSortList(createList(List())) should be(null)
    i.insertionSortList(createList(List(1))) should be(createList(List(1)))
    i.insertionSortList(createList(List(1,2))) should be(createList(List(1,2)))
    i.insertionSortList(createList(List(2,1))) should be(createList(List(1,2)))
    i.insertionSortList(createList(List(2,1,3,6,3,1))) should be(createList(List(1,1,2,3,3,6)))
    i.insertionSortList(createList(List(6,5,4,3,2,1))) should be(createList(List(1,2,3,4,5,6)))
    i.insertionSortList(createList(List(1,2,3,4,5,6))) should be(createList(List(1,2,3,4,5,6)))
  }
}
