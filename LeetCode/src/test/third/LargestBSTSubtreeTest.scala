package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class LargestBSTSubtreeTest extends FunSuite with ShouldMatchers with TreeHelper {
  val t = new LargestBSTSubtree

  test("should work") {
    t.largestBST(createTree(List(10))) should be(1)
    t.largestBST(createTree(List(10,5,5))) should be(1)
    t.largestBST(createTree(List(10,5,15))) should be(3)
    t.largestBST(createTree(List(10,15,15,-1,-1,11))) should be(2)
    t.largestBST(createTree(List(10,5,5,1,6))) should be(3)
    t.largestBST(createTree(List(10,5,15,1,8,-1,-1,-1,-1,-1,7))) should be(3)
    t.largestBST(createTree(List(10,5,15,1,8,-1,-1,-1,-1,-1,19))) should be(6)
    t.largestBST(createTree(List(10,5,15,1,8,-1,-1,-1,-1,12,19))) should be(7)
    t.largestBST(createTree(List(10,5,15,1,8))) should be(5)
    t.largestBST(createTree(List(10,5,9,1,8))) should be(3)
    t.largestBST(createTree(List(10,5,15,1,8,-1,-1,-1,-1, 12))) should be(6)
    t.largestBST(createTree(List(5,7,8,9,10,-1,-1,-1,-1,3,4))) should be(1)

    t.largestBST(createTree(List(50,60,60,-1,-1,45,70,-1,-1,65,80))) should be(5)
  }

  test("slow version should work") {
    t.largestBST_slow(createTree(List(10))) should be(1)
    t.largestBST_slow(createTree(List(10,5,5))) should be(1)
    t.largestBST_slow(createTree(List(10,5,15))) should be(3)
    t.largestBST_slow(createTree(List(10,15,15,-1,-1,11))) should be(2)
    t.largestBST_slow(createTree(List(10,5,5,1,6))) should be(3)
    t.largestBST_slow(createTree(List(10,5,15,1,8,-1,-1,-1,-1,-1,7))) should be(3)
    t.largestBST_slow(createTree(List(10,5,15,1,8,-1,-1,-1,-1,-1,19))) should be(6)
    t.largestBST_slow(createTree(List(10,5,15,1,8,-1,-1,-1,-1,12,19))) should be(7)
    t.largestBST_slow(createTree(List(10,5,15,1,8))) should be(5)
    t.largestBST_slow(createTree(List(10,5,9,1,8))) should be(3)
    t.largestBST_slow(createTree(List(10,5,15,1,8,-1,-1,-1,-1, 12))) should be(6)
    t.largestBST_slow(createTree(List(5,7,8,9,10,-1,-1,-1,-1,3,4))) should be(1)

    t.largestBST_slow(createTree(List(50,60,60,-1,-1,45,70,-1,-1,65,80))) should be(5)
  }
}
