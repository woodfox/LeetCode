package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class MaximumPathSumTest extends FunSuite with ShouldMatchers with TreeHelper  {
  val m = new MaximumPathSum

  test("should work") {
    m.maxPathSum(createTree(List(1))) should be(1)
    m.maxPathSum(createTree(List(-1))) should be(-1)
    m.maxPathSum(createTree(List(-2,2,3))) should be(3)
    m.maxPathSum(createTree(List(-1,2))) should be(2)
    m.maxPathSum(createTree(List(-3,2,4))) should be(4)
    m.maxPathSum(createTree(List(-3,2,1))) should be(2)
    m.maxPathSum(createTree(List(-3,1,2,3,4))) should be(8)
    m.maxPathSum(createTree(List(-3,-2,-2,3,4))) should be(5)
    m.maxPathSum(createTree(List(-3,-2,-2,-3,4))) should be(4)
    m.maxPathSum(createTree(List(-3,-2,-2,3,-4))) should be(3)
    m.maxPathSum(createTree(List(-3,-2,-2,-3,-4))) should be(-2)
    m.maxPathSum(createTree(List(1,2,3))) should be(6)
  }
}
