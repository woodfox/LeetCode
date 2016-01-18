package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestConsecutiveSeqTest extends FunSuite with ShouldMatchers {
  val l = new LongestConsecutiveSeq

  test("should work") {
    l.longestConsecutive(Array(3,4,100,7,5,6,-1,500)) should be(5)
    l.longestConsecutive(Array(3)) should be(1)
    l.longestConsecutive(Array(3,2)) should be(2)
    l.longestConsecutive(Array(3,2,4,2)) should be(3)
    l.longestConsecutive(Array(3,2,4,2,3,0)) should be(3)
    l.longestConsecutive(Array(3,2,4,2,3,7,2,-1,1)) should be(4)
    l.longestConsecutive(Array(4,3,2,1)) should be(4)
    l.longestConsecutive(Array(1,10,2,10,3,10,4)) should be(4)
    l.longestConsecutive(Array(1,1,1,1,1,1,1,3,3,3,3,3,5,5,5,5,5)) should be(1)
  }
}
