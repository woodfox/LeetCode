package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SearchInRotatedArrayTest extends FunSuite with ShouldMatchers {
  val s = new SearchInRotatedArray

  test("should find the value in rotated array"){
    s.search(Array(), 4) should be(-1)
    s.search(Array(4), 4) should be(0)
    s.search(Array(4), 5) should be(-1)
    s.search(Array(4,5), 4) should be(0)
    s.search(Array(4,5), 5) should be(1)
    s.search(Array(4,5), 3) should be(-1)
    s.search(Array(4,5), 7) should be(-1)
    s.search(Array(4,5,6,7,1,2,3), 4) should be(0)
    s.search(Array(4,5,6,7,1,2,3), 5) should be(1)
    s.search(Array(4,5,6,7,1,2,3), 6) should be(2)
    s.search(Array(4,5,6,7,1,2,3), 7) should be(3)
    s.search(Array(4,5,6,7,1,2,3), 1) should be(4)
    s.search(Array(4,5,6,7,1,2,3), 2) should be(5)
    s.search(Array(4,5,6,7,1,2,3), 3) should be(6)
    s.search(Array(4,5,6,7,1,2,3), 8) should be(-1)
    s.search(Array(4,5,6,7,1,2,3), 0) should be(-1)
  }
}
