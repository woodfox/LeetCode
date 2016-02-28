package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class CountUnivalueSubtreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  test("should work") {
    val c = new CountUnivalueSubtree
    c.countUnivalSubtrees(createTree(List())) should be(0)
    c.countUnivalSubtrees(createTree(List(1))) should be(1)
    c.countUnivalSubtrees(createTree(List(1,2))) should be(2)
    c.countUnivalSubtrees(createTree(List(1,2,3))) should be(3)
    c.countUnivalSubtrees(createTree(List(1,2,2))) should be(3)
    c.countUnivalSubtrees(createTree(List(2,2,2))) should be(1)
    c.countUnivalSubtrees(createTree(List(2,1,2))) should be(2)
    c.countUnivalSubtrees(createTree(List(2,1,1))) should be(3)
    c.countUnivalSubtrees(createTree(List(2,2,1))) should be(2)
    c.countUnivalSubtrees(createTree(List(1,2,3,2,3))) should be(4)
    c.countUnivalSubtrees(createTree(List(1,2,3,2,2))) should be(3)
    c.countUnivalSubtrees(createTree(List(1,2,2,2,2))) should be(3)
    c.countUnivalSubtrees(createTree(List(2,2,2,2,2))) should be(1)
    c.countUnivalSubtrees(createTree(List(2,2,2,2,3))) should be(2)
    c.countUnivalSubtrees(createTree(List(2,2,2,3,3))) should be(3)
    c.countUnivalSubtrees(createTree(List(2,3,2,3,3))) should be(2)
    c.countUnivalSubtrees(createTree(List(2,3,3,3,3))) should be(3)
    c.countUnivalSubtrees(createTree(List(3,3,3,3,3))) should be(1)
  }
}
