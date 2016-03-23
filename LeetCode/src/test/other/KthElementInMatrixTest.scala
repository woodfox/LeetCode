package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class KthElementInMatrixTest extends FunSuite with ShouldMatchers {
  val t = new KthElementInMatrix

  test("should work") {
    t.kthSmallest(Array(Array(1,5,7),Array(3,7,8),Array(4,8,9)), 4) should be(5)
  }
}
