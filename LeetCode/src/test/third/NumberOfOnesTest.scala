package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class NumberOfOnesTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val n = new NumberOfOnes
    n.hammingWeight(1) should be(1)
    n.hammingWeight(2) should be(1)
    n.hammingWeight(3) should be(2)
    n.hammingWeight(4) should be(1)
    n.hammingWeight(9) should be(2)
    n.hammingWeight(15) should be(3)
    n.hammingWeight(Integer.MIN_VALUE) should be(1)
    n.hammingWeight(Integer.MAX_VALUE) should be(31)
  }
}
