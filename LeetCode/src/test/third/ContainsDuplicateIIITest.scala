package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ContainsDuplicateIIITest extends FunSuite with ShouldMatchers {
  val c = new ContainsDuplicateIII

  test("should work") {
    c.containsNearbyAlmostDuplicate(Array(-1,-1), 1, -1) should be(false)
    c.containsNearbyAlmostDuplicate(Array(0,Integer.MAX_VALUE), 1, Integer.MAX_VALUE) should be(true)
    c.containsNearbyAlmostDuplicate(Array(3,7,0,5,9,6), 2, 2) should be(true)
    c.containsNearbyAlmostDuplicate(Array(3,7,0,5,9,6), 1, 2) should be(false)
  }
}
