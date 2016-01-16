package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class InOrderTraversalTest extends FunSuite with ShouldMatchers with TreeHelper {
  val t = new InOrderTraversal

  test("should work") {
    t.inorderTraversal(createTree(List(1,-1,2,3))).toList should be(List(1,3,2))
    t.inorderTraversal(createTree(List(1,2,3,-1,-1,-1,-1))).toList should be(List(2,1,3))
    t.inorderTraversal(createTree(List(1,-1,2,3,-1,-1,4))).toList should be(List(1,3,4,2))
    t.inorderTraversal(createTree(List(1,2,3,4,5,-1,-1,6,-1,-1,7,3,-1,8,-1,-1))).toList should be(List(4,2,6,7,5,1,3,9,8))
  }
}
