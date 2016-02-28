package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class PostOrderTraversalTest extends FunSuite with ShouldMatchers with TreeHelper {
  val p = new PostOrderTraversal

  test("should work") {
    p.postorderTraversal(createTree(List(1))).toList should be(List(1))
    p.postorderTraversal(createTree(List(1,2))).toList should be(List(2,1))
    p.postorderTraversal(createTree(List(1,2,3))).toList should be(List(2,3,1))
    p.postorderTraversal(createTree(List(1,2,3,4))).toList should be(List(4,2,3,1))
    p.postorderTraversal(createTree(List(1,2,3,4,5))).toList should be(List(4,5,2,3,1))
    p.postorderTraversal(createTree(List(1,-1,2,3,4))).toList should be(List(3,4,2,1))
  }
}
