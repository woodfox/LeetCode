package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class BinaryTreePathTest extends FunSuite with ShouldMatchers with TreeHelper {
  val b = new BinaryTreePath

  test("should work") {
    b.binaryTreePaths(createTree(List())).toList should be(List())
    b.binaryTreePaths(createTree(List(1))).toList should be(List("1"))
    b.binaryTreePaths(createTree(List(1,2))).toList should be(List("1->2"))
    b.binaryTreePaths(createTree(List(1,2,3))).toList should be(List("1->2","1->3"))
    b.binaryTreePaths(createTree(List(1,2,3,4))).toList should be(List("1->2->4","1->3"))
    b.binaryTreePaths(createTree(List(1,2,3,4,5))).toList should be(List("1->2->4","1->2->5","1->3"))
    b.binaryTreePaths(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6))).toList should be(List("1->2->4","1->2->5","1->3->6"))
    b.binaryTreePaths(createTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))).toList should be(List("1->2->4","1->2->5","1->3->6","1->3->7"))
  }
}
