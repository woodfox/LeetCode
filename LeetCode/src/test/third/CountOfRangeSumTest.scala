package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 */
class CountOfRangeSumTest extends FunSuite with ShouldMatchers {
  val t = new CountOfRangeSum

  test("prefix sort version should work") {
    t.countRangeSum(Array(), -1, 3) should be(0)
    t.countRangeSum(Array(-1,1), 0, 0) should be(1)
    t.countRangeSum(Array(2), -1, 3) should be(1)
    t.countRangeSum(Array(2,1), -1, 3) should be(3)
    t.countRangeSum(Array(2,3), -1, 3) should be(2)
    t.countRangeSum(Array(2,-1,3), -1, 3) should be(5)
    t.countRangeSum(Array(-2,5,-1), -2, 2) should be(3)
    t.countRangeSum(Array(1,-3,2,5,4), -3, 6) should be(10)

    t.countRangeSum(Array(-2147483647,0,-2147483647,2147483647), -564, 3864) should be(3)
  }

  test("BST version should work") {
    t.countRangeSum_BST(Array(), -1, 3) should be(0)
    t.countRangeSum_BST(Array(-1,1), 0, 0) should be(1)
    t.countRangeSum_BST(Array(2), -1, 3) should be(1)
    t.countRangeSum_BST(Array(2,1), -1, 3) should be(3)
    t.countRangeSum_BST(Array(2,3), -1, 3) should be(2)
    t.countRangeSum_BST(Array(2,-1,3), -1, 3) should be(5)
    t.countRangeSum_BST(Array(-2,5,-1), -2, 2) should be(3)
    t.countRangeSum_BST(Array(1,-3,2,5,4), -3, 6) should be(10)

    t.countRangeSum_BST(Array(-2147483647,0,-2147483647,2147483647), -564, 3864) should be(3)
  }

  test("naive way should work") {
        t.countRangeSum_naive(Array(), -1, 3) should be(0)
        t.countRangeSum_naive(Array(-1,1), 0, 0) should be(1)
        t.countRangeSum_naive(Array(2), -1, 3) should be(1)
        t.countRangeSum_naive(Array(2,1), -1, 3) should be(3)
        t.countRangeSum_naive(Array(2,3), -1, 3) should be(2)
        t.countRangeSum_naive(Array(2,-1,3), -1, 3) should be(5)
        t.countRangeSum_naive(Array(-2,5,-1), -2, 2) should be(3)
        t.countRangeSum_naive(Array(1,-3,2,5,4), -3, 6) should be(10)

        t.countRangeSum_naive(Array(-2147483647,0,-2147483647,2147483647), -564, 3864) should be(3)
  }
}
