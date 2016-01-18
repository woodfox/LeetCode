package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.LinkedTreeHelper

class PopulateNextPointerIITest extends FunSuite with ShouldMatchers with LinkedTreeHelper {
  val p = new PopulateNextPointerII

  test("should work") {
    val root = createLinkedTree(List(1,2,3,4,5,-1,7,-1,-1,-1,-1,-1,6,8))
    p.connect(root)

    val firstLevel1 = root.left
    val firstLevel2 = root.right
    firstLevel1.next should be(firstLevel2)
    firstLevel2.next should be(null)

    val secondLevel1 = firstLevel1.left
    val secondLevel2 = firstLevel1.right
    val secondLevel3 = firstLevel2.right
    secondLevel1.next should be(secondLevel2)
    secondLevel2.next should be(secondLevel3)
    secondLevel3.next should be(null)

    val thirdLevel1 = secondLevel1.right
    val thirdLevel2 = secondLevel3.left
    thirdLevel1.next should be(thirdLevel2)
    thirdLevel2.next should be(null)
  }
}
