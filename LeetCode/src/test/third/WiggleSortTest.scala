package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WiggleSortTest extends FunSuite with ShouldMatchers {
  val w = new WiggleSort

  test("should work") {
    var a = Array(3,1,4,2,6,7,5)
    w.wiggleSort(a)
    a should be(Array(1,3,2,5,4,7,6))

    a = Array(3,1,4,2,6,5)
    w.wiggleSort(a)
    a should be(Array(1,3,2,5,4,6))

    a = Array(3,1,2)
    w.wiggleSort(a)
    a should be(Array(1,3,2))

    a = Array(3,1,4,2,6,7,5)
    w.wiggleSort_fast(a)
    a should be(Array(1,4,2,6,3,7,5))

    a = Array(3,1,4,2,6,5)
    w.wiggleSort_fast(a)
    a should be(Array(1,4,2,6,3,5))

    a = Array(3,1,2)
    w.wiggleSort_fast(a)
    a should be(Array(1,3,2))
  }
}
