package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

import scala.collection.JavaConversions._

class BinaryTreeRightViewTest extends FunSuite with ShouldMatchers with TreeHelper {
  val b = new BinaryTreeRightView

  test("should work") {
    b.rightSideView(null).toList should be(List())
    b.rightSideView(createTree(List(1,2,3))).toList should be(List(1,3))
    b.rightSideView(createTree(List(1,2,3,4))).toList should be(List(1,3,4))
    b.rightSideView(createTree(List(1,2,3,4,5))).toList should be(List(1,3,5))
    b.rightSideView(createTree(List(1,2,-1,3,4))).toList should be(List(1,2,4))
    b.rightSideView(createTree(List(1,2,-1,3,4,5,6))).toList should be(List(1,2,4,6))
    b.rightSideView(createTree(List(1,2,-1,3,4,5,-1,6))).toList should be(List(1,2,4,5,6))
    b.rightSideView(createTree(List(1,2,-1,3,4,5,-1,6,7))).toList should be(List(1,2,4,5,7))
  }
}
