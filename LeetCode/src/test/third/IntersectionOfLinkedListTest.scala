package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListNode, ListHelper}

class IntersectionOfLinkedListTest extends FunSuite with ShouldMatchers with ListHelper {
  val i = new IntersectionOfLinkedList

  test("should work") {
    i.getIntersectionNode(createList(List(1,2,3,4)), createList(List(5,6,7,8))) should be(null)
    i.getIntersectionNode(createList(List(1,2,3,4)), createList(List())) should be(null)
    i.getIntersectionNode(createList(List()), createList(List(5,6,7,8))) should be(null)

    val common = createList(List(5,6,7,8))
    var first = createList(List(1,2))
    endOfList(first).next = common
    var second = createList(List(1,2,3,4))
    endOfList(second).next = common
    i.getIntersectionNode(first, second).`val` should be(5)

    first = createList(List(1,2,3,4))
    second = createList(List(1,2))
    endOfList(first).next = common
    endOfList(second).next = common
    i.getIntersectionNode(first, second).`val` should be(5)

    first = createList(List(1))
    second = createList(List(1))
    endOfList(first).next = common
    endOfList(second).next = common
    i.getIntersectionNode(first, second).`val` should be(5)
  }
}
