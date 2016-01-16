package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MedianOfTwoArrayTest extends FunSuite with ShouldMatchers {
  val instance = new MedianOfTwoArray()

  test("it should find median element of two sorted array") {
    instance.findMedianSortedArrays(Array(), Array()) should be(-1)
    instance.findMedianSortedArrays(Array(), Array(1)) should be(1)
    instance.findMedianSortedArrays(Array(), Array(1,2)) should be(1.5d)
    instance.findMedianSortedArrays(Array(), Array(1,2,3)) should be(2)
    instance.findMedianSortedArrays(Array(1), Array()) should be(1)
    instance.findMedianSortedArrays(Array(1,2), Array()) should be(1.5d)
    instance.findMedianSortedArrays(Array(1,2,3), Array()) should be(2)
    instance.findMedianSortedArrays(Array(2,3,4), Array(1)) should be(2.5d)
    instance.findMedianSortedArrays(Array(2, 3, 7), Array(1, 4, 8, 9, 11)) should be(5.5d)
    instance.findMedianSortedArrays(Array(2, 6, 10), Array(1, 4, 5, 9)) should be(5)
    instance.findMedianSortedArrays(Array(2, 3, 10), Array(1, 4, 5, 9)) should be(4)
    instance.findMedianSortedArrays(Array(1, 5, 7, 8), Array(4, 5, 6, 11)) should be(5.5d)
    instance.findMedianSortedArrays(Array(1, 5, 8), Array(4, 5, 9, 12)) should be(5)
    instance.findMedianSortedArrays(Array(1, 5, 7), Array( 4, 5, 6, 11)) should be(5)
    instance.findMedianSortedArrays(Array(1, 3, 5, 7, 8), Array(2, 4, 5, 9, 11)) should be(5)
    instance.findMedianSortedArrays(Array(1, 2), Array(5, 6)) should be(3.5d)
    instance.findMedianSortedArrays(Array(1, 9), Array(3, 5)) should be(4)
  }
}
