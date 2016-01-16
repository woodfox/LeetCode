package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SearchInsertPositionTest extends FunSuite with ShouldMatchers {
  val s = new SearchInsertPosition

  test("should find the insertion position") {
    s.searchInsert(Array(1), 0) should be(0)
    s.searchInsert(Array(1), 2) should be(1)
    s.searchInsert(Array(1,3), 2) should be(1)
    s.searchInsert(Array(1,3), 6) should be(2)
    s.searchInsert(Array(1,3,5,6), 0) should be(0)
    s.searchInsert(Array(1,3,5,6), 1) should be(0)
    s.searchInsert(Array(1,3,5,6), 2) should be(1)
    s.searchInsert(Array(1,3,5,6), 3) should be(1)
    s.searchInsert(Array(1,3,5,6), 4) should be(2)
    s.searchInsert(Array(1,3,5,6), 5) should be(2)
    s.searchInsert(Array(1,3,5,6), 6) should be(3)
    s.searchInsert(Array(1,3,5,6), 7) should be(4)
  }
}
