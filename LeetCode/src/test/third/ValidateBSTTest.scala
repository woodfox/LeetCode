package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class ValidateBSTTest extends FunSuite with ShouldMatchers with TreeHelper {
  val v = new ValidateBST

  test("should work") {
    v.isValidBST(createTree(List())) should be(true)
    v.isValidBST(createTree(List(9))) should be(true)
    v.isValidBST(createTree(List(Integer.MAX_VALUE))) should be(true)
    v.isValidBST(createTree(List(Integer.MIN_VALUE))) should be(true)
    v.isValidBST(createTree(List(9,5,-1))) should be(true)
    v.isValidBST(createTree(List(9,5,12,3,6,-1,-1,-1,-1,10,14))) should be(true)
    v.isValidBST(createTree(List(9,5,12,3,10,-1,-1,-1,-1,10,14))) should be(false)
    v.isValidBST(createTree(List(9,5,12,3,6,-1,-1,-1,-1,8,14))) should be(false)
  }
}
