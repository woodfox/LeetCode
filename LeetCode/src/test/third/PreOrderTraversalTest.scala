package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class PreOrderTraversalTest extends FunSuite with ShouldMatchers with TreeHelper {
  val p = new PreOrderTraversal

  test("should work") {
    p.preorderTraversal(createTree(List(1))).toList should be(List(1))
    p.preorderTraversal(createTree(List(1,2))).toList should be(List(1,2))
    p.preorderTraversal(createTree(List(1,2,3))).toList should be(List(1,2,3))
    p.preorderTraversal(createTree(List(1,2,3,4))).toList should be(List(1,2,4,3))
    p.preorderTraversal(createTree(List(1,2,3,4,5))).toList should be(List(1,2,4,5,3))
    p.preorderTraversal(createTree(List(1,-1,2,3,4))).toList should be(List(1,2,3,4))
  }
}
