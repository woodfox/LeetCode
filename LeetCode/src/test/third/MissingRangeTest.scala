package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class MissingRangeTest extends FunSuite with ShouldMatchers {
  val m = new MissingRange

  test("should work") {
    m.findMissingRanges(Array(), 5, 99).toList should be(List("5->99"))
    m.findMissingRanges(Array(0), 0, 99).toList should be(List("1->99"))
    m.findMissingRanges(Array(1), 0, 99).toList should be(List("0->0","2->99"))
    m.findMissingRanges(Array(1,10), 0, 99).toList should be(List("0->0","2->9","11->99"))
    m.findMissingRanges(Array(1,2,2,3,3,3,5,6,8,9), 0, 99).toList should be(List("0->0","4->4","7->7","10->99"))
    m.findMissingRanges(Array(0,3,3,5,6), 0, 99).toList should be(List("1->2","4->4","7->99"))
  }
}
