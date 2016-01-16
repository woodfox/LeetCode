package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SearchInRotatedArrayIITest extends FunSuite with ShouldMatchers {
  val s = new SearchInRotatedArrayII

  test("should work"){
    s.search(Array(1,1,1,3,1,1,1), 1) should be(true)
    s.search(Array(1,1,1,3,1,1,1), 2) should be(false)
    s.search(Array(1,1,1,3,1,1,1), 3) should be(true)
    s.search(Array(1,1,1,3,1,1,1), 4) should be(false)
    s.search(Array(1,1,1,3,1,1,1), 0) should be(false)
    s.search(Array(1,1,1,3,4,5,6,7,1,1,1), 2) should be(false)
    s.search(Array(1,1,1,3,4,5,6,7,1,1,1), 4) should be(true)
    s.search(Array(1,1,1,3,4,5,6,7,1,1,1), 8) should be(false)
  }
}
