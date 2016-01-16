package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class UniqueBinaryTreeTest extends FunSuite with ShouldMatchers {
  val u = new UniqueBinaryTree

  test("Should work") {
    u.numTrees(1) should be(1)
    u.numTrees(2) should be(2)
    u.numTrees(3) should be(5)
  }
}
