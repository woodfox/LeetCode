package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RemoveElementInArrayTest extends FunSuite with ShouldMatchers {
  val r = new RemoveElementInArray

  test("should remove the element") {
    val a = Array(1,2,1,3,4,2,1)
    r.removeElement(a, 1) should be(4)
    a.take(4) should be(Array(2,3,4,2))
  }

  test("should remove all element") {
    val a = Array(1,1,1,1,1,1,1,1,1)
    r.removeElement(a, 1) should be(0)
  }

  test("should remove the element at last") {
    val a = Array(1,2,1,3,2,2,2,2)
    r.removeElement(a, 2) should be(3)
    a.take(3) should be(Array(1,1,3))
  }
}
