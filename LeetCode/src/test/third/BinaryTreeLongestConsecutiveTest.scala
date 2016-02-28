package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class BinaryTreeLongestConsecutiveTest extends FunSuite with ShouldMatchers with TreeHelper {
  val t = new BinaryTreeLongestConsecutive

  test("should work") {
    t.longestConsecutive(createTree(List())) should be(0)
    t.longestConsecutive(createTree(List(1))) should be(1)
    t.longestConsecutive(createTree(List(1,2))) should be(2)
    t.longestConsecutive(createTree(List(1,2,3))) should be(2)
    t.longestConsecutive(createTree(List(1,-1,2,3,-1,-1,4,5,-1))) should be(5)
    t.longestConsecutive(createTree(List(1,2,-1,3,-1,4,4,-1,-1,-1,5,-1,-1))) should be(5)
  }
}
