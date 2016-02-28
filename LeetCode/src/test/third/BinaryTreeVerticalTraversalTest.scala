package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListHelper, TreeHelper}

class BinaryTreeVerticalTraversalTest extends FunSuite with ShouldMatchers with TreeHelper with ListHelper {
  val t = new BinaryTreeVerticalTraversal

  test("should work") {
    convertJavaListToSet(t.verticalOrder(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7)))) should be(
      Set(List(4),List(2),List(1,5,6),List(3),List(7)))

    convertJavaListToSet(t.verticalOrder(createTree(List(1,2,3,4,5)))) should be(
      Set(List(4),List(2),List(1,5),List(3)))

    convertJavaListToSet(t.verticalOrder(createTree(List(1,2,3,-1,5,-1,-1,6,-1,-1,7)))) should be(
      Set(List(2),List(1,5,6),List(3,7)))
  }
}
