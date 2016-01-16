package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListHelper, TreeHelper}

class BinaryTreeLevelOrderTraversalTest extends FunSuite with TreeHelper with ListHelper with ShouldMatchers {
  test("should work") {
    val b = new BinaryTreeLevelOrderTraversal
    convertJavaList(b.levelOrder(createTree(List(1)))) should be(List(List(1)))
    convertJavaList(b.levelOrder(createTree(List(1,2)))) should be(List(List(1), List(2)))
    convertJavaList(b.levelOrder(createTree(List(1,2,3)))) should be(List(List(1), List(2, 3)))
    convertJavaList(b.levelOrder(createTree(List(1,2,3,-1,-1,4,5)))) should be(List(List(1), List(2,3), List(4,5)))
    convertJavaList(b.levelOrder(createTree(List(1,2,3,4,5)))) should be(List(List(1), List(2,3), List(4,5)))
    convertJavaList(b.levelOrder(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7)))) should be(List(List(1), List(2,3), List(4,5,6,7)))
    convertJavaList(b.levelOrder(createTree(List(1,2,3,4,5,6,7)))) should be(List(List(1), List(2,3), List(4,5), List(6,7)))
  }
}
