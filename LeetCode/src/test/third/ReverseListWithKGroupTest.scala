package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class ReverseListWithKGroupTest extends FunSuite with ShouldMatchers with ListHelper {
  val r = new ReverseListWithKGroup

  test("should reverse in k group"){
    compareList(
      r.reverseKGroup(createList(List()), 2),
      createList(List())
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2,3)), 1),
      createList(List(1,2,3))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1)), 2),
      createList(List(1))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2)), 2),
      createList(List(2,1))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2,3)), 2),
      createList(List(2,1,3))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2,3,4)), 2),
      createList(List(2,1,4,3))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2,3,4,5,6)), 3),
      createList(List(3,2,1,6,5,4))
    ) should be(true)

    compareList(
      r.reverseKGroup(createList(List(1,2,3,4,5,6,7,8)), 3),
      createList(List(3,2,1,6,5,4,7,8))
    ) should be(true)
  }
}
