package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ContainsDuplicateIITest extends FunSuite with ShouldMatchers {
  test("should work") {
    val c =  new ContainsDuplicateII

    c.containsNearbyDuplicate(Array(-1,-1), 1) should be(true)
    c.containsNearbyDuplicate(Array(1,1), 1) should be(true)
  }
}
