package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class HammingSequenceTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val h = new HammingSequence

    h.getSeq(1).toList should be(List(1))
    h.getSeq(2).toList should be(List(1,2))
    h.getSeq(5).toList should be(List(1,2,3,4,5))
    h.getSeq(10).toList should be(List(1,2,3,4,5,6,8,9,10,12))
  }
}
