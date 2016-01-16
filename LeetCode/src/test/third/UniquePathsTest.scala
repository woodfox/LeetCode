package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class UniquePathsTest extends FunSuite with ShouldMatchers {
  val u = new UniquePaths

  test("Should get total paths") {
    u.uniquePaths(1,1) should be(1)
    u.uniquePaths(1,2) should be(1)
    u.uniquePaths(3,1) should be(1)
    u.uniquePaths(2,2) should be(2)
    u.uniquePaths(2,3) should be(3)
    u.uniquePaths(3,6) should be(21)
  }
}
