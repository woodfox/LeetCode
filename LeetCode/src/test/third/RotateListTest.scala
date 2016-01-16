package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class RotateListTest extends FunSuite with ShouldMatchers with ListHelper {
  val r = new RotateList

  test("Should rotate list"){
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 1), createList(List(5,1,2,3,4))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 2), createList(List(4,5,1,2,3))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 3), createList(List(3,4,5,1,2))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 4), createList(List(2,3,4,5,1))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 5), createList(List(1,2,3,4,5))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 7), createList(List(4,5,1,2,3))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 9), createList(List(2,3,4,5,1))) should be(true)
    compareList(r.rotateRight(createList(List(1,2,3,4,5)), 10), createList(List(1,2,3,4,5))) should be(true)

  }
}
