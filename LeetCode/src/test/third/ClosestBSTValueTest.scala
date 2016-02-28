package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.TreeHelper

class ClosestBSTValueTest extends FunSuite with ShouldMatchers with TreeHelper {
  val c = new ClosestBSTValue

  test("should work") {
    c.closestValue(createTree(List(2,1,3)), -0.3) should be(1)
    c.closestValue(createTree(List(2,1,3)), 0.3) should be(1)
    c.closestValue(createTree(List(2,1,3)), 1.3) should be(1)
    c.closestValue(createTree(List(2,1,3)), 1.6) should be(2)
    c.closestValue(createTree(List(2,1,3)), 1.91) should be(2)
    c.closestValue(createTree(List(2,1,3)), 2.3) should be(2)
    c.closestValue(createTree(List(2,1,3)), 2.91) should be(3)
    c.closestValue(createTree(List(2,1,3)), 3.91) should be(3)

    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 9.99999) should be(7)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 5.99999) should be(6)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 3.91) should be(4)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 3.11) should be(3)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.91) should be(3)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 2.11) should be(2)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 1.91) should be(2)
    c.closestValue(createTree(List(4,2,6,1,3,-1,-1,-1,-1,5,7)), 1.11) should be(1)

  }
}
