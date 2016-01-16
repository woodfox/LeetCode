package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class PathSumTest extends FunSuite with ShouldMatchers with TreeHelper {
  test("should work") {
    val p = new PathSum

    p.hasPathSum(createTree(List(1)), 1) should be(true)
    p.hasPathSum(createTree(List(1)), 2) should be(false)
    p.hasPathSum(createTree(List(1)), 0) should be(false)
    p.hasPathSum(createTree(List(1,2)), 1) should be(false)
    p.hasPathSum(createTree(List(1,2)), 2) should be(false)
    p.hasPathSum(createTree(List(1,2)), 3) should be(true)
    p.hasPathSum(createTree(List(1,2)), 4) should be(false)
    p.hasPathSum(createTree(List(1,2,3)), 4) should be(true)
    p.hasPathSum(createTree(List(1,2,3)), 5) should be(false)
    p.hasPathSum(createTree(List(1,2,3)), 1) should be(false)
    p.hasPathSum(createTree(List(1,2,3)), 2) should be(false)
    p.hasPathSum(createTree(List(1,2,3,4)), 6) should be(false)
    p.hasPathSum(createTree(List(1,2,3,4)), 7) should be(true)
    p.hasPathSum(createTree(List(1,2,3,4)), 4) should be(true)
    p.hasPathSum(createTree(List(1,2,3,4)), 8) should be(false)
    p.hasPathSum(createTree(List(1,2,3,4,5)), 8) should be(true)

    p.hasPathSum(createTree(List(-2)), -2) should be(true)
    p.hasPathSum(createTree(List(-2,-3)), -5) should be(true)
    p.hasPathSum(createTree(List(-2,-3)), -2) should be(false)
    p.hasPathSum(createTree(List(-2,-3)), -3) should be(false)
    p.hasPathSum(createTree(List(-2,-3)), -6) should be(false)
    p.hasPathSum(createTree(List(-2,-3,-4)), -5) should be(true)
    p.hasPathSum(createTree(List(-2,-3,-4)), -7) should be(false)
    p.hasPathSum(createTree(List(-2,-3,-4,-5)), -10) should be(true)
    p.hasPathSum(createTree(List(-2,-3,-4,-5)), -6) should be(true)
    p.hasPathSum(createTree(List(-2,-3,-4,-5)), -9) should be(false)

    p.hasPathSum(createTree(List(1,-3,3,4,5)), 2) should be(true)
    p.hasPathSum(createTree(List(1,-3,3,4,-5)), -7) should be(true)
  }

}
