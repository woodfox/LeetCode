package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class CountCompleteTreeNodesTest extends FunSuite with ShouldMatchers with TreeHelper {
  val c = new CountCompleteTreeNodes
  test("should work") {
    c.countNodes(createTree(List(1,2,3,4,5))) should be(5)
    c.countNodes(createTree(List(1,2,3))) should be(3)
    c.countNodes(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))) should be(7)
  }
}
