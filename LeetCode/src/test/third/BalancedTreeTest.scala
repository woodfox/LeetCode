package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class BalancedTreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  test("should work") {
    val b = new BalancedTree
    b.isBalanced(createTree(List())) should be(true)
    b.isBalanced(createTree(List(1))) should be(true)
    b.isBalanced(createTree(List(1,2))) should be(true)
    b.isBalanced(createTree(List(1,2,3))) should be(true)
    b.isBalanced(createTree(List(1,2,3,4))) should be(true)
    b.isBalanced(createTree(List(1,2,-1,4))) should be(false)
    b.isBalanced(createTree(List(1,2,3,4,5))) should be(true)
    b.isBalanced(createTree(List(1,2,-1,4,5))) should be(false)
    b.isBalanced(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6))) should be(true)
    b.isBalanced(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))) should be(true)
    b.isBalanced(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7,8))) should be(true)
    b.isBalanced(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,-1,8,9,10))) should be(false)
  }
}
