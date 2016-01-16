package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class RemoveNthNodeFromEndTest extends FunSuite with ShouldMatchers with ListHelper {
  val r = new RemoveNthNodeFromEnd

  test("should remove the Nth element") {
    compareList(r.removeNthFromEnd(createList(List(1)), 1), createList(List())) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1, 2)), 2),createList(List(2))) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1,2,3,4,5)), 1), createList(List(1,2,3,4))) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1,2,3,4,5)), 2), createList(List(1,2,3,5))) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1,2,3,4,5)), 3), createList(List(1,2,4,5))) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1,2,3,4,5)), 4), createList(List(1,3,4,5))) should be(true)
    compareList(r.removeNthFromEnd(createList(List(1,2,3,4,5)), 5), createList(List(2,3,4,5))) should be(true)
  }

}
