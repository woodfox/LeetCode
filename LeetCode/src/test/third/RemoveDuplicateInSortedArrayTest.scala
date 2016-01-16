package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RemoveDuplicateInSortedArrayTest extends FunSuite with ShouldMatchers {
  val r = new RemoveDuplicateInSortedArray

  test("should remove duplicated and return new length with one element") {
    val a = Array(1)
    r.removeDuplicates(a) should be(1)
    a.take(1) should be(Array(1))
  }

  test("should remove duplicated and return new length with same element") {
    val a = Array(1,1,1,1,1)
    r.removeDuplicates(a) should be(1)
    a.take(1) should be(Array(1))
  }

  test("should remove duplicated and return new length with three elements") {
    val a = Array(1,1,2,3)
    r.removeDuplicates(a) should be(3)
    a.take(3) should be(Array(1,2,3))
  }

  test("should remove duplicated and return new length with duplicated three elements") {
    val a = Array(1,1,2,2,2,3,3,3)
    r.removeDuplicates(a) should be(3)
    a.take(3) should be(Array(1,2,3))
  }

  test("should remove duplicated and return new length with duplicated at last") {
    val a = Array(1,2,3,3,3,3,3,3,3,3)
    r.removeDuplicates(a) should be(3)
    a.take(3) should be(Array(1,2,3))
  }
}
