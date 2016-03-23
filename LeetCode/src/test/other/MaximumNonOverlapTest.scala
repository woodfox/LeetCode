package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers
import util.Interval

import scala.collection.mutable.ListBuffer

class MaximumNonOverlapTest extends FunSuite with ShouldMatchers {
  val t = new MaximumNonOverlap

  test("should work") {
    t.maxNonOverlap(ListBuffer[Interval]()) should be(0)
    t.maxNonOverlap(ListBuffer(new Interval(1,3))) should be(1)
    t.maxNonOverlap(ListBuffer(new Interval(1,3), new Interval(4,5))) should be(2)
    t.maxNonOverlap(ListBuffer(new Interval(1,3), new Interval(2,5))) should be(0)
    t.maxNonOverlap(ListBuffer(new Interval(1,3), new Interval(2,5), new Interval(4,5))) should be(2)
    t.maxNonOverlap(ListBuffer(new Interval(1,3), new Interval(4,5), new Interval(6,7))) should be(3)
    t.maxNonOverlap(ListBuffer(new Interval(1,5), new Interval(2,3), new Interval(4,5))) should be(2)
  }
}
