package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RemoveDuplicatesIITest extends FunSuite with ShouldMatchers {
  val r = new RemoveDuplicatesII

  test("should work") {
    r.removeDuplicates(Array(1)) should be(1)
    r.removeDuplicates(Array(1,1,1,1,1,1)) should be(2)
    r.removeDuplicates(Array(1,1,1,1,1,1,2,2,2,2,2,2)) should be(4)
    r.removeDuplicates(Array(1,1,1,1,1,1,2,3,4)) should be(5)
    r.removeDuplicates(Array(1,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4)) should be(8)
  }
}
