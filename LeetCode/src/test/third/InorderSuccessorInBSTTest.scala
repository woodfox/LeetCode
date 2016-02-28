package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class InorderSuccessorInBSTTest extends FunSuite with ShouldMatchers with TreeHelper {
  val t = new InorderSuccessorInBST

  test("should work") {
    val root = createTree(List(5,3,8,1,4,-1,-1,-1,-1,6,9,-1,7))
    var node = root.left
    t.inorderSuccessor(root, node).`val` should be(4)

    node = root.left.right
    t.inorderSuccessor(root, node).`val` should be(5)

    node = root.left.left
    t.inorderSuccessor(root, node).`val` should be(3)

    node = root
    t.inorderSuccessor(root, node).`val` should be(6)

    node = root.right
    t.inorderSuccessor(root, node).`val` should be(9)

    node = root.right.left
    t.inorderSuccessor(root, node).`val` should be(7)

    node = root.right.right
    t.inorderSuccessor(root, node) should be(null)

    node = root.right.left.right
    t.inorderSuccessor(root, node).`val` should be(8)
  }

  test("general version should work") {
    val root = createTree(List(5,3,8,1,4,-1,-1,-1,-1,6,9,-1,7))
    var node = root.left
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(4)

    node = root.left.right
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(5)

    node = root.left.left
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(3)

    node = root
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(6)

    node = root.right
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(9)

    node = root.right.left
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(7)

    node = root.right.right
    t.inorderSuccessor_anyBinaryTree(root, node) should be(null)

    node = root.right.left.right
    t.inorderSuccessor_anyBinaryTree(root, node).`val` should be(8)
  }
}
