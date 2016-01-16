package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class RemoveDuplicateInSortedListIITest extends FunSuite with ListHelper with ShouldMatchers {
  val r = new RemoveDuplicateInSortedListII

  test("should work") {
    val actual = r.deleteDuplicates(createList(List(1,1,1,2,2,2,3,3,3)))
    compareList(actual, null) should be(true)

    val actual2 = r.deleteDuplicates(createList(List(1,1,1,2,2,2,3)))
    compareList(actual2, createList(List(3))) should be(true)

    val actual3 = r.deleteDuplicates(createList(List(1)))
    compareList(actual3, createList(List(1))) should be(true)

    val actual4 = r.deleteDuplicates(createList(List(1,2,2,2,3)))
    compareList(actual4, createList(List(1,3))) should be(true)

    val actual5 = r.deleteDuplicates(createList(List(1)))
    compareList(actual5, createList(List(1))) should be(true)

    val actual6 = r.deleteDuplicates(createList(List(1,2,3,4,5,6)))
    compareList(actual6, createList(List(1,2,3,4,5,6))) should be(true)
  }
}
