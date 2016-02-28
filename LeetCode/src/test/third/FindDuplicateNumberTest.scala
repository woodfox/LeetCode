package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FindDuplicateNumberTest extends FunSuite with ShouldMatchers {
  val t = new FindDuplicateNumber

  test("should work") {
    t.findDuplicate(Array(1,2,2,3,4,5,6,7)) should be(2)
  }
}
