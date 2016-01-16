package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class MinDepthOfBinaryTreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  test("should work") {
    val m = new MinDepthOfBinaryTree

    m.minDepth(null) should be(0)
    m.minDepth(createTree(List(1))) should be(1)
    m.minDepth(createTree(List(1,2))) should be(2)
    m.minDepth(createTree(List(1,2,3))) should be(2)
    m.minDepth(createTree(List(1,2,3,4))) should be(2)
    m.minDepth(createTree(List(1,2,3,4,5))) should be(2)
    m.minDepth(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6))) should be(3)
    m.minDepth(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))) should be(3)
    m.minDepth(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7,8))) should be(3)
    m.minDepth(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7,8,9))) should be(3)
    m.minDepth(createTree(List(1,2,3,4,5,6,7,-1,-1,-1,-1,8,9))) should be(2)
    m.minDepth(createTree(List(1,2,-1,3,4,-1,-1,-1,-1,8,9))) should be(3)
  }
}
