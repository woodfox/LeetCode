package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class LinkedListCycleTest extends FunSuite with ShouldMatchers with ListHelper {
  val l = new LinkedListCycle

  test("should work") {
    l.hasCycle(null) should be(false)
    l.hasCycle(createList(List(1))) should be(false)
    l.hasCycle(createList(List(1,2,3,4,5,6,7))) should be(false)
    l.hasCycle(createList(List(1,2,3,4,5,6,7))) should be(false)

    val listHead = createList(List(1,2,3,4,5,6,7))
    var last = listHead
    while(last.next != null) {
      last = last.next
    }
    last.next = listHead
    l.hasCycle(listHead) should be(true)
  }
}
