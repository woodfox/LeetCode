package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class RecorderListTest extends FunSuite with ShouldMatchers with ListHelper {
  val r = new RecorderList

  test("should work") {
    r.move(createList(List())) should be(createList(List()))
    r.move(createList(List(1))) should be(createList(List(1)))
    r.move(createList(List(1,2))) should be(createList(List(1,2)))
    r.move(createList(List(1,2,3))) should be(createList(List(1,3,2)))
    r.move(createList(List(1,2,3,4,5))) should be(createList(List(1,5,2,4,3)))
  }
}
