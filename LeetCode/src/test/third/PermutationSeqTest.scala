package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PermutationSeqTest extends FunSuite with ShouldMatchers {
  val p = new PermutationSeq

  test("should get kth permutation") {
    p.getPermutation(1, 1) should be("1")
    p.getPermutation(2, 1) should be("12")
    p.getPermutation(2, 2) should be("21")
    p.getPermutation(3, 1) should be("123")
    p.getPermutation(3, 2) should be("132")
    p.getPermutation(3, 3) should be("213")
    p.getPermutation(3, 4) should be("231")
    p.getPermutation(3, 5) should be("312")
    p.getPermutation(3, 6) should be("321")
  }
}
