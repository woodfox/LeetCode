package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MatrixZerosTest extends FunSuite with ShouldMatchers {
  val m = new MatrixZeros

  test("Should set rows and cols to 0"){
    val matrix = Array(Array(1,2,0),Array(0,1,2),Array(1,2,3))
    m.setZeroes(matrix)
    matrix should be(Array(Array(0,0,0),Array(0,0,0),Array(0,2,0)))
  }

  test("Should set rows and cols to 0 for one line"){
    val matrix = Array(Array(1,0))
    m.setZeroes(matrix)
    matrix should be(Array(Array(0,0)))
  }
}
