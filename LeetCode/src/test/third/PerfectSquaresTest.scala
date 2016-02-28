package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class PerfectSquaresTest extends FunSuite with ShouldMatchers {
  val p = new PerfectSquares

  test("should work") {
    p.numSquares(12) should be(3)
    p.numSquares(1) should be(1)
    p.numSquares(2) should be(2)
    p.numSquares(3) should be(3)
    p.numSquares(4) should be(1)
    p.numSquares(5) should be(2)
    p.numSquares(13) should be(2)
    p.numSquares(29) should be(2)
    p.numSquares(78) should be(3)
  }

  test("improved recursive version should work") {
    p.numSquares_recur(12) should be(3)
    p.numSquares_recur(1) should be(1)
    p.numSquares_recur(2) should be(2)
    p.numSquares_recur(3) should be(3)
    p.numSquares_recur(4) should be(1)
    p.numSquares_recur(5) should be(2)
    p.numSquares_recur(13) should be(2)
    p.numSquares_recur(29) should be(2)
    p.numSquares_recur(78) should be(3)
  }

  test("faster version should work") {
    p.numSquares_fast(12) should be(3)
    p.numSquares_fast(1) should be(1)
    p.numSquares_fast(2) should be(2)
    p.numSquares_fast(3) should be(3)
    p.numSquares_fast(4) should be(1)
    p.numSquares_fast(5) should be(2)
    p.numSquares_fast(13) should be(2)
    p.numSquares_fast(29) should be(2)
    p.numSquares_fast(78) should be(3)
  }


  test("DP version should work") {
    p.numSquares_dp(12) should be(3)
    p.numSquares_dp(1) should be(1)
    p.numSquares_dp(2) should be(2)
    p.numSquares_dp(3) should be(3)
    p.numSquares_dp(4) should be(1)
    p.numSquares_dp(5) should be(2)
    p.numSquares_dp(13) should be(2)
    p.numSquares_dp(29) should be(2)
    p.numSquares_dp(78) should be(3)
  }
}
