package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class BinaryTreeUpsideDownTest extends FunSuite with ShouldMatchers with TreeHelper {
  val b = new BinaryTreeUpsideDown

  test("should work") {
//    b.UpsideDownBinaryTree(createTree(List(1))) should be(createTree(List(1)))
//    b.UpsideDownBinaryTree(createTree(List(1,2,3))) should be(createTree(List(2,3,1)))
    b.UpsideDownBinaryTree(createTree(List(1,2,3,4,5))) should be(createTree(List(4,5,2,-1,-1,3,1)))
    b.UpsideDownBinaryTree(createTree(List(1,2,3,4,5,6,7))) should be(createTree(List(6,7,4,-1,-1,5,2,-1,-1,3,1)))
  }
}
