package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListHelper, TreeHelper}

class MaxTreeDepthTest extends FunSuite with ShouldMatchers with TreeHelper with ListHelper {
  val m = new MaxTreeDepth

  test("should work") {
    m.maxDepth(createTree(List())) should be(0)
    m.maxDepth(createTree(List(1))) should be(1)
    m.maxDepth(createTree(List(1,2))) should be(2)
    m.maxDepth(createTree(List(1,2,3))) should be(2)
    m.maxDepth(createTree(List(1,2,3,4,5))) should be(3)
    m.maxDepth(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))) should be(3)
    m.maxDepth(createTree(List(1,2,3,4,5,-1,-1,6,7))) should be(4)
  }
}
