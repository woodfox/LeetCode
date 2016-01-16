package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class MergeSortedListTest extends FunSuite with ShouldMatchers with ListHelper {
  val m = new MergeSortedList

  test("should merge two sorted list") {
    compareList(
      m.mergeTwoLists(createList(List(1)), createList(List(2))),
      createList(List(1,2))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List(3)), createList(List(2))),
      createList(List(2, 3))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List(3)), createList(List(2, 4))),
      createList(List(2, 3, 4))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List(1)), createList(List(2,3))),
      createList(List(1,2,3))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List(1,2,4)), createList(List(2,3,5,7))),
      createList(List(1,2,2,3,4,5,7))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List(1,2,4)), createList(List())),
      createList(List(1,2,4))
    ) should be(true)

    compareList(
      m.mergeTwoLists(createList(List()), createList(List(1,2,4))),
      createList(List(1,2,4))
    ) should be(true)
  }
}
