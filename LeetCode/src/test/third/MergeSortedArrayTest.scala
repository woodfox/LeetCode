package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MergeSortedArrayTest extends FunSuite with ShouldMatchers {
  val m = new MergeSortedArray

  test("should work") {
    val array = Array(1,4,6,9,0,0,0,0,0)
    m.merge(array, 4, Array(2,3,5,7,10), 5)
    array should be(Array(1,2,3,4,5,6,7,9,10))
  }

  test("should work if one is empty") {
    val array = Array(1,4,6,9,0,0,0,0,0)
    m.merge(array, 4, Array(2,3,5,7,10), 0)
    array should be(Array(1,4,6,9,0,0,0,0,0))
  }

  test("should work if one is larger than another one") {
    val array = Array(1,4,6,9,0,0,0,0,0)
    m.merge(array, 4, Array(12,13,15,17,20), 5)
    array should be(Array(1,4,6,9,12,13,15,17,20))
  }

  test("should work if one is smaller than another one") {
    val array = Array(11,14,16,19,0,0,0,0,0)
    m.merge(array, 4, Array(2,3,5,7,10), 5)
    array should be(Array(2,3,5,7,10,11,14,16,19))
  }
}
