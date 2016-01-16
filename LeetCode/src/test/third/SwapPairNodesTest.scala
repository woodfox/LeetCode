package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class SwapPairNodesTest extends FunSuite with ShouldMatchers with ListHelper {
  val s = new SwapPairNodes

  test("should swap pair nodes") {
    compareList(
      s.swapPairs(createList(List())),
      createList(List())
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1))),
      createList(List(1))
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1,2))),
      createList(List(2,1))
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1,2,3))),
      createList(List(2,1,3))
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1,2,3,4))),
      createList(List(2,1,4,3))
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1,2,3,4,5))),
      createList(List(2,1,4,3,5))
    ) should be(true)

    compareList(
      s.swapPairs(createList(List(1,2,3,4,5,6))),
      createList(List(2,1,4,3,6,5))
    ) should be(true)
  }
}
