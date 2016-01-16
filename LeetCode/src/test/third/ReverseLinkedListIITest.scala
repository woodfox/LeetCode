package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class ReverseLinkedListIITest extends FunSuite with ShouldMatchers with ListHelper {
  val r = new ReverseLinkedListII

  test("should work"){
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 1, 1),
                createList(List(1,2,3,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 1, 2),
                createList(List(2,1,3,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 1, 3),
      createList(List(3,2,1,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 1, 4),
      createList(List(4,3,2,1,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 1, 5),
      createList(List(5,4,3,2,1))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 2, 2),
      createList(List(1,2,3,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 2, 3),
      createList(List(1,3,2,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 2, 4),
      createList(List(1,4,3,2,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 2, 5),
      createList(List(1,5,4,3,2))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 3, 3),
      createList(List(1,2,3,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 3, 4),
      createList(List(1,2,4,3,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 3, 5),
      createList(List(1,2,5,4,3))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 4, 4),
      createList(List(1,2,3,4,5))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 4, 5),
      createList(List(1,2,3,5,4))) should be(true)
    compareList(r.reverseBetween(createList(List(1,2,3,4,5)), 5, 5),
      createList(List(1,2,3,4,5))) should be(true)
  }
}
