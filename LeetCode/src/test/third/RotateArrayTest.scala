package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RotateArrayTest extends FunSuite with ShouldMatchers {
  test("rotateBySwap should work") {
    val r = new RotateArray
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 0) should be(Array(1, 2, 3, 4, 5, 6, 7))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 1) should be(Array(7, 1, 2, 3, 4, 5, 6))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 2) should be(Array(6, 7, 1, 2, 3, 4, 5))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 3) should be(Array(5, 6, 7, 1, 2, 3, 4))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 4) should be(Array(4, 5, 6, 7, 1, 2, 3))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 5) should be(Array(3, 4, 5, 6, 7, 1, 2))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 6) should be(Array(2, 3, 4, 5, 6, 7, 1))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 7) should be(Array(1, 2, 3, 4, 5, 6, 7))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 8) should be(Array(7, 1, 2, 3, 4, 5, 6))
    r.rotateBySwap(Array(1, 2, 3, 4, 5, 6, 7), 9) should be(Array(6, 7, 1, 2, 3, 4, 5))
  }

  test("rotateByMove should work") {
    val r = new RotateArray
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 0) should be(Array(1, 2, 3, 4, 5, 6, 7))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 1) should be(Array(7, 1, 2, 3, 4, 5, 6))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 2) should be(Array(6, 7, 1, 2, 3, 4, 5))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 3) should be(Array(5, 6, 7, 1, 2, 3, 4))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 4) should be(Array(4, 5, 6, 7, 1, 2, 3))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 5) should be(Array(3, 4, 5, 6, 7, 1, 2))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 6) should be(Array(2, 3, 4, 5, 6, 7, 1))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 7) should be(Array(1, 2, 3, 4, 5, 6, 7))
    r.rotateByMove(Array(1, 2, 3, 4, 5, 6, 7), 8) should be(Array(7, 1, 2, 3, 4, 5, 6))
  }
}
