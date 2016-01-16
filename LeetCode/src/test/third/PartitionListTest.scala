package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class PartitionListTest extends FunSuite with ListHelper with ShouldMatchers {
  val p = new PartitionList

  test("should work"){
    println(printList(p.partition(createList(List(3,5,6,1,7,1,2)), 3)))

    compareList(p.partition(createList(List(3,5,6,1,7,1,2)), 3),
      createList(List(1,1,2,3,5,6,7)))  should be(true)

    compareList(p.partition(createList(List(3,5,6,1,7,1,2)), 9),
      createList(List(3,5,6,1,7,1,2)))  should be(true)

    compareList(p.partition(createList(List(3,5,6,1,7,1,2)), 0),
      createList(List(3,5,6,1,7,1,2)))  should be(true)

    compareList(p.partition(createList(List(3,5,6,1,7,1,2)), 6),
      createList(List(3,5,1,1,2,6,7)))  should be(true)
  }
}
