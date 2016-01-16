package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MatrixSearchTest extends FunSuite with ShouldMatchers {
  val m = new MatrixSearch

  test("should work"){
    val matrix = Array(Array(1,   3,  5,  7),
                       Array(10, 11, 16, 20),
                       Array(23, 30, 34, 50))

    m.searchMatrix(matrix, 1) should be(true)
    m.searchMatrix(matrix, 3) should be(true)
    m.searchMatrix(matrix, 7) should be(true)
    m.searchMatrix(matrix, 10) should be(true)
    m.searchMatrix(matrix, 16) should be(true)
    m.searchMatrix(matrix, 20) should be(true)
    m.searchMatrix(matrix, 23) should be(true)
    m.searchMatrix(matrix, 34) should be(true)
    m.searchMatrix(matrix, 50) should be(true)
    m.searchMatrix(matrix, 0) should be(false)
    m.searchMatrix(matrix, 4) should be(false)
    m.searchMatrix(matrix, 8) should be(false)
    m.searchMatrix(matrix, 9) should be(false)
    m.searchMatrix(matrix, 12) should be(false)
    m.searchMatrix(matrix, 15) should be(false)
    m.searchMatrix(matrix, 17) should be(false)
    m.searchMatrix(matrix, 19) should be(false)
    m.searchMatrix(matrix, 21) should be(false)
    m.searchMatrix(matrix, 25) should be(false)
    m.searchMatrix(matrix, 29) should be(false)
    m.searchMatrix(matrix, 32) should be(false)
    m.searchMatrix(matrix, 49) should be(false)
    m.searchMatrix(matrix, 55) should be(false)
  }
}
