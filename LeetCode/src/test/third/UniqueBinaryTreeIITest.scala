package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper
import scala.collection.JavaConversions._

class UniqueBinaryTreeIITest extends FunSuite with ShouldMatchers with TreeHelper {
  val u = new UniqueBinaryTreeII

  test("should work") {
    u.generateTrees(1).toSet should be(Set(createTree(List(1, -1, -1))))
    u.generateTrees(2).toSet should be(Set(createTree(List(1, -1, 2,-1,-1)), createTree(List(2,1,-1,-1,-1))))
    u.generateTrees(3).toSet should be(Set(createTree(List(1, -1, 3, 2, -1,-1,-1)),
      createTree(List(1,-1,2,-1,3,-1,-1)), createTree(List(2,1,3,-1,-1,-1,-1)),
      createTree(List(3,2,-1,1,-1,-1,-1)), createTree(List(3,1,-1,-1,2,-1,-1))))
  }
}
