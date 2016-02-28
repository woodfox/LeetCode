package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class LinkedListCycleIITest extends FunSuite with ShouldMatchers with ListHelper{
  val l = new LinkedListCycleII

  test("should work") {
    l.detectCycle(createList(List(1,2))) should be(null)
    l.detectCycle(createList(List(1))) should be(null)
    l.detectCycle(createList(List())) should be(null)

    val head = createList(List(1,2,3,4,5,6,7))
    var last = head
    while(last.next != null) last = last.next
    last.next = head.next
    l.detectCycle(head) should be(head.next)

    // Head is cycle start
    last.next = head;
    l.detectCycle(head) should be(head)
  }
}
