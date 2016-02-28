package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WiggleSortIITest extends FunSuite with ShouldMatchers {
  val t= new WiggleSortII

  test("should work") {
    val a = Array(4,5,5,6)
    t.wiggleSort(a)
    a should be(Array(5,6,4,5))

    val b = Array(1,2,2,1,3,3)
    t.wiggleSort(b)
    b should be(Array(2, 3, 1, 3, 1, 2))  // One case

    val c = Array(1,2,2,1,2,1,1,1,2,2,1,2,1,2,1,1,2)
    t.wiggleSort(c)
    c should be(Array(1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1))  // One case
  }

  test("QuickFind version should work") {
    val a = Array(4,5,5,6)
    t.wiggleSort(a)
    a should be(Array(5,6,4,5))

    val b = Array(1,2,2,1,3,3)
    t.wiggleSort(b)
    b should be(Array(2, 3, 1, 3, 1, 2))  // One case

    val c = Array(1,2,2,1,2,1,1,1,2,2,1,2,1,2,1,1,2)
    t.wiggleSort(c)
    c should be(Array(1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1))  // One case
  }
}
