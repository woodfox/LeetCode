package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class SymmetricTreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  val s = new SymmetricTree

  test("") {
    s.isSymmetric(createTree(List())) should be(true)
    s.isSymmetric(createTree(List(1))) should be(true)
    s.isSymmetric(createTree(List(1, 2, 2))) should be(true)
    s.isSymmetric(createTree(List(1, 2))) should be(false)
    s.isSymmetric(createTree(List(1, 2, 3))) should be(false)
    s.isSymmetric(createTree(List(1, -1, 3))) should be(false)

    s.isSymmetric(createTree(List(1, 2, 2, 3, 4, -1, -1, -1, -1, 4, 3))) should be(true)
    s.isSymmetric(createTree(List(1, 2, 2, 3, 4, -1, -1, -1, -1, 4, 5))) should be(false)
    s.isSymmetric(createTree(List(1, 2, 2, 3, 4, -1, -1, -1, -1, 4))) should be(false)
    s.isSymmetric(createTree(List(1, 2, 2, 3, 4, -1, -1, -1, -1, 3, 4))) should be(false)
  }
}
