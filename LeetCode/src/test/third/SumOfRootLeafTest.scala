package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class SumOfRootLeafTest extends FunSuite with ShouldMatchers with TreeHelper {
  val s = new SumOfRootLeaf

  test("should work") {
    s.sumNumbers(createTree(List())) should be(0)
    s.sumNumbers(createTree(List(1))) should be(1)
    s.sumNumbers(createTree(List(1,2))) should be(12)
    s.sumNumbers(createTree(List(1,2,3))) should be(25)
    s.sumNumbers(createTree(List(1,2,3,4))) should be(137)
    s.sumNumbers(createTree(List(1,2,3,4,5))) should be(262)
  }

}
