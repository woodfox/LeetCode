package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestIncreasingSeqTest extends FunSuite with ShouldMatchers {
  val l = new LongestIncreasingSeq

  test("should work") {
    l.lengthOfLIS(Array(10,9,2,5,3,4)) should be(3)
    l.lengthOfLIS(Array(10,9,2,3,3,4)) should be(3)
    l.lengthOfLIS(Array(1,9,2,3,3,4)) should be(4)
    l.lengthOfLIS(Array(1,3,6,7,9,4,10,5,6)) should be(6)
  }
}
