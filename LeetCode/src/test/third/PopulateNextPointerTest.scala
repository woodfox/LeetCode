package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.LinkedTreeHelper

class PopulateNextPointerTest extends FunSuite with ShouldMatchers with LinkedTreeHelper {
  val p = new PopulateNextPointer

  test("should work") {
    val root = createLinkedTree(List(1,2,3,4,5,-1,-1,-1,-1,6,7))
    p.connect(root)
    root.next should be(null)

    val secondLevelLeft = root.left
    val secondLevelRight = root.right
    secondLevelLeft.next should be(secondLevelRight)
    secondLevelLeft.left.next should be(secondLevelLeft.right)
    secondLevelLeft.right.next should be(secondLevelRight.left)
    secondLevelRight.left = secondLevelRight.right
  }
}
