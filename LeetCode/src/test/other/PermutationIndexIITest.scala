package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PermutationIndexIITest extends FunSuite with ShouldMatchers {
  val t = new PermutationIndexII

  test("should work") {
    t.permutationIndexII(Array(3,2,2,1,1)) should be(30)
    t.permutationIndexII(Array(1,4,2,2)) should be(3)
    t.permutationIndexII(Array(22,9,9,11,11,9,14,8,9,9,9,8,6,9,9,9,9,10,10,20)) should be(81598260145L)
  }
}
