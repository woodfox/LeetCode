package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MedianFinderTest extends FunSuite with ShouldMatchers {
  val t = new MedianFinder

  test("should work") {
    t.addNum(2)
    t.findMedian() should be(2)

    t.addNum(5)
    t.findMedian() should be(3.5)

    t.addNum(3)
    t.findMedian() should be(3)

    t.addNum(6)
    t.findMedian() should be(4)

    t.addNum(7)
    t.findMedian() should be(5)

    t.addNum(0)
    t.findMedian() should be(4)

    t.addNum(2)
    t.findMedian() should be(3)
  }

  test("slower version should work") {
    t.addNum_slow(2)
    t.findMedian_slow() should be(2)

    t.addNum_slow(5)
    t.findMedian_slow() should be(3.5)

    t.addNum_slow(3)
    t.findMedian_slow() should be(3)

    t.addNum_slow(6)
    t.findMedian_slow() should be(4)

    t.addNum_slow(7)
    t.findMedian_slow() should be(5)

    t.addNum_slow(0)
    t.findMedian_slow() should be(4)

    t.addNum_slow(2)
    t.findMedian_slow() should be(3)
  }
}
