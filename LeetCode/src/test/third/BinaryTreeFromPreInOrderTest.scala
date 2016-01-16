package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class BinaryTreeFromPreInOrderTest extends FunSuite with ShouldMatchers with TreeHelper {
  val b = new BinaryTreeFromPreInOrder

  test("should work") {
    compareTree(
      b.buildTree(Array(1), Array(1)),
      createTree(List(1))
    ) should be(true)

    compareTree(
      b.buildTree(Array(1,2), Array(2,1)),
      createTree(List(1,2))
    ) should be(true)

    compareTree(
      b.buildTree(Array(1,2,4), Array(4,2,1)),
      createTree(List(1,2,-1,4))
    ) should be(true)

    compareTree(
      b.buildTree(Array(1,2,3), Array(2,1,3)),
      createTree(List(1,2,3))
    ) should be(true)

    compareTree(
      b.buildTree(Array(1,2,4,5,3), Array(4,2,5,1,3)),
      createTree(List(1,2,3,4,5))
    ) should be(true)

    compareTree(
      b.buildTree(Array(1,2,4,5,3,6,7), Array(4,2,5,1,6,3,7)),
      createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))
    ) should be(true)
  }
}
