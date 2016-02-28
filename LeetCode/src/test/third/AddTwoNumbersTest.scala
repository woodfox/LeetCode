package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListNode

class AddTwoNumbersTest extends FunSuite with ShouldMatchers {
  test("it should add two list correctly") {
    val instance: AddTwoNumbers = new AddTwoNumbers
    var l1: ListNode = createList(Array[Int](1))
    var l2: ListNode = createList(Array[Int]())
    compareList(instance.addTwoNumbers(l1, l2), createList(Array[Int](1))) should be(true)

    l1 = createList(Array(9, 9, 9))
    l2 = createList(Array(1))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array[Int](0, 0, 0, 1))) should be(true)

    l1 = createList(Array(9, 9, 9))
    l2 = createList(Array(9, 9, 9, 9))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array(8, 9, 9, 0, 1))) should be(true)

    l1 = createList(Array(9, 9, 9))
    l2 = createList(Array(0))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array(9, 9, 9))) should be(true)

    l1 = createList(Array(9, 9, 9))
    l2 = createList(Array(1, 1, 1))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array(0, 1, 1, 1))) should be(true)

    l1 = createList(Array(1, 2, 2))
    l2 = createList(Array(8, 8, 8, 8))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array(9, 0, 1, 9))) should be(true)

    l1 = createList(Array(5))
    l2 = createList(Array(5))
    compareList(instance.addTwoNumbers(l1, l2), createList(Array(0, 1))) should be(true)

    l1 = createList(Array())
    l2 = createList(Array())
    compareList(instance.addTwoNumbers(l1, l2), createList(Array())) should be(true)
  }

  def createList (array: Array[Int]): ListNode = {
    if (array.length == 0) {
      return null
    }

    val head = new ListNode(array(0))
    array.drop(1).foldLeft(head){ (prev, currentVal) =>
      prev.next = new ListNode(currentVal)
      prev.next
    }
    return head;
  }

  def compareList(a: ListNode, b: ListNode): Boolean = {
    if (a == null && b == null) {
      return true
    }
    if (a != null && b != null) {
      return (a.`val` == b.`val`) && compareList(a.next, b.next)
    }

    return false
  }
}
