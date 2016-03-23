package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SubMatrixSumTest extends FunSuite with ShouldMatchers {
  val t = new SubMatrixSum

  test("should work") {
    t.submatrixSum(Array(Array(1,5,7),Array(3,7,-8),Array(4,-8,9))) should be(Array(Array(1,1),Array(2,2)))
  }
}
