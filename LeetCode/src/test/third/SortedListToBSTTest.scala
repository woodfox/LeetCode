package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{TreeHelper, ListHelper}

class SortedListToBSTTest extends FunSuite with ShouldMatchers with ListHelper with TreeHelper {
  val s = new SortedListToBST

  test("should work") {
    compareTree(
      s.sortedListToBST(createList(List(1))),
      createTree(List(1))
    ) should be(true)

    compareTree(
      s.sortedListToBST(createList(List(1,2))),
      createTree(List(1,-1,2))
    ) should be(true)

    compareTree(
      s.sortedListToBST(createList(List(1,2,3))),
      createTree(List(2,1,3))
    ) should be(true)

    compareTree(
      s.sortedListToBST(createList(List(1,2,3,4))),
      createTree(List(2,1,3,-1,-1,-1,4))
    ) should be(true)

    compareTree(
      s.sortedListToBST(createList(List(1,2,3,4,5))),
      createTree(List(3,1,4,-1,2,-1,-1,-1,5))
    ) should be(true)
  }
}
