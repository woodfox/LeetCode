package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class RemoveListElementTest extends FunSuite with ShouldMatchers with ListHelper {
  test("should work") {
    val r = new RemoveListElement
    r.removeElements(createList(List()), 2) should be(createList(List()))
    r.removeElements(createList(List(2)), 2) should be(createList(List()))
    r.removeElements(createList(List(3)), 2) should be(createList(List(3)))
    r.removeElements(createList(List(2,2,2,2,2)), 2) should be(createList(List()))
    r.removeElements(createList(List(2,2,2,2,2)), 3) should be(createList(List(2,2,2,2,2)))
    r.removeElements(createList(List(2,2,5,2,6,2,7,2)), 2) should be(createList(List(5,6,7)))
    r.removeElements(createList(List(2,2,5,2,6,2,7,2)), 6) should be(createList(List(2,2,5,2,2,7,2)))
    r.removeElements(createList(List(1,2,3,4,5)), 6) should be(createList(List(1,2,3,4,5)))
  }
}
