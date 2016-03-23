package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestIncreasingSeqInMatrixTest extends FunSuite with ShouldMatchers {
  val t = new LongestIncreasingSeqInMatrix

  test("should work") {
    t.longestSeq(Array(Array())) should be(0)
    t.longestSeq(Array(Array(1))) should be(1)
    t.longestSeq(Array(Array(1,2))) should be(2)
    t.longestSeq(Array(Array(1,2,3))) should be(3)
    t.longestSeq(Array(Array(3,2,1))) should be(3)
    t.longestSeq(Array(Array(3,2,1,4,5))) should be(3)
    t.longestSeq(Array(Array(1,2,3,4),Array(8,7,6,5))) should be(8)
    t.longestSeq(Array(Array(1,2,3,4),Array(5,6,8,7))) should be(6)
    t.longestSeq(Array(Array(1,2,3,4),Array(5,6,7,8))) should be(5)
  }
}
