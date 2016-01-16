package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListHelper, TreeHelper}

class ZigzagLevelOrderTraversalTest extends FunSuite with ShouldMatchers with TreeHelper with ListHelper {
  val z = new ZigzagLevelOrderTraversal
  test("should work") {
    convertJavaList(z.zigzagLevelOrder(createTree(List(1)))) should be(List(List(1)))
    convertJavaList(z.zigzagLevelOrder(createTree(List(1,2,3)))) should be(List(List(1), List(3,2)))
    convertJavaList(z.zigzagLevelOrder(createTree(List(1,2,3,4,5)))) should be(List(List(1), List(3,2), List(4,5)))
    convertJavaList(z.zigzagLevelOrder(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7)))) should be(List(List(1), List(3,2), List(4,5,6,7)))
    convertJavaList(z.zigzagLevelOrder(createTree(List(1,2,3,4,5,8,9,-1,-1,-1,-1,-1,-1,6,7)))) should be(List(List(1), List(3,2), List(4,5,6,7),List(9,8)))
    convertJavaList(z.zigzagLevelOrder(createTree(List(1,2,3,4,5,8,9,10,11)))) should be(List(List(1), List(3,2), List(4,5),List(11,10,9,8)))
  }
}
