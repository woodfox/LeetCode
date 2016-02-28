package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class VerifyPreorderOfBSTTest extends FunSuite with ShouldMatchers {
  val v = new VerifyPreorderOfBST

  test("should work") {
    v.verifyPreorder(Array(5,3,2,1,4,8)) should be(true)
    v.verifyPreorder(Array(5,3,8)) should be(true)
    v.verifyPreorder(Array(5,3)) should be(true)
    v.verifyPreorder(Array(5)) should be(true)
    v.verifyPreorder(Array(5,3,2,1,4,8,6,7,12)) should be(true)
    v.verifyPreorder(Array(5,3,6,1,4,8,6,7,12)) should be(false)
    v.verifyPreorder(Array(5,3,2,1,4,8,3,7,12)) should be(false)
    v.verifyPreorder(Array(5,3,2,1,4,8,7,12,6)) should be(false)
  }
}
