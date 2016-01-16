package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class RecoverBinaryTreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  val r = new RecoverBinaryTree

  /**
   *       5
   *      /  \
   *     3   7
   *    /\   /\
   *   2 4  6  9
   */
  test("should work") {
    r.recoverTreeFast(createTree(List(2,-1,1))) should be(createTree(List(1,-1,2)))
    r.recoverTreeFast(createTree(List(1,2,-1))) should be(createTree(List(2,1,-1)))
    r.recoverTreeFast(createTree(List(1,2,3))) should be(createTree(List(2,1,3)))
    r.recoverTreeFast(createTree(List(3,1,2))) should be(createTree(List(2,1,3)))
    r.recoverTreeFast(createTree(List(2,3,1))) should be(createTree(List(2,1,3)))
    r.recoverTreeFast(createTree(List(2,3,7,5,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(4,3,7,2,5,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(3,5,7,2,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,2,7,3,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,4,7,2,3,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(7,3,5,2,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(6,3,7,2,4,-1,-1,-1,-1,5,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(9,3,7,2,4,-1,-1,-1,-1,6,5))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,7,3,2,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,6,7,2,4,-1,-1,-1,-1,3,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,9,7,2,4,-1,-1,-1,-1,6,3))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,3,2,7,4,-1,-1,-1,-1,6,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,3,7,2,6,-1,-1,-1,-1,4,9))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
    r.recoverTreeFast(createTree(List(5,3,7,2,9,-1,-1,-1,-1,6,4))) should be(createTree(List(5,3,7,2,4,-1,-1,-1,-1,6,9)))
  }

}
