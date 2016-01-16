package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class FlattenTreeToListTest extends FunSuite with ShouldMatchers with TreeHelper {
  val f = new FlattenTreeToList

  test("should work") {
    f.flattenTree(createTree(List())) should be(createTree(List()))
    f.flattenTree(createTree(List(1))) should be(createTree(List(1)))
    f.flattenTree(createTree(List(1,2))) should be(createTree(List(1,-1,2)))
    f.flattenTree(createTree(List(1,-1,2))) should be(createTree(List(1,-1,2)))
    f.flattenTree(createTree(List(1,2,3))) should be(createTree(List(1,-1,2,-1,3)))
    f.flattenTree(createTree(List(1,2,3,4))) should be(createTree(List(1,-1,2,-1,4,-1,3)))
    f.flattenTree(createTree(List(1,2,3,4,5))) should be(createTree(List(1,-1,2,-1,4,-1,5,-1,3)))
    f.flattenTree(createTree(List(1,2,-1,3,-1,4))) should be(createTree(List(1,-1,2,-1,3,-1,4)))
  }
}
