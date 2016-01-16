package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SearchForRangeTest extends FunSuite with ShouldMatchers {
  val s = new SearchForRange

  test("should search for range"){
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 3) should be(Array(-1,-1))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 5) should be(Array(0,0))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 6) should be(Array(-1,-1))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 7) should be(Array(1,2))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 8) should be(Array(3,4))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 9) should be(Array(-1,-1))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 10) should be(Array(5,5))
    s.searchRange(Array(5, 7, 7, 8, 8, 10), 15) should be(Array(-1,-1))
    s.searchRange(Array(5, 7, 7), 5) should be(Array(0,0))
    s.searchRange(Array(5, 7), 5) should be(Array(0,0))
    s.searchRange(Array(5), 5) should be(Array(0,0))
    s.searchRange(Array(), 5) should be(Array(-1,-1))
  }
}
