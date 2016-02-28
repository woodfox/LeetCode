package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class TwoSumWithSortedArrayTest extends FunSuite with ShouldMatchers {
  val t = new TwoSumWithSortedArray

  test("should work") {
    t.twoSum(Array(1), 7) should be(Array(-1,-1))
    t.twoSum(Array(1,3), 7) should be(Array(-1,-1))
    t.twoSum(Array(1,3), 4) should be(Array(0,1))
    t.twoSum(Array(1,3), 2) should be(Array(-1,-1))

    t.twoSum(Array(1,3,4,6,8,9), 10) should be(Array(0,5))
    t.twoSum(Array(1,3,4,6,8,9), 9) should be(Array(0,4))
    t.twoSum(Array(1,3,4,6,8,9), 8) should be(Array(-1,-1))
    t.twoSum(Array(1,3,4,6,8,9), 7) should be(Array(0,3))
    t.twoSum(Array(1,3,4,6,8,9), 6) should be(Array(-1,-1))
    t.twoSum(Array(1,3,4,6,8,9), 5) should be(Array(0,2))
    t.twoSum(Array(1,3,4,6,8,9), 4) should be(Array(0,1))
    t.twoSum(Array(1,3,4,6,8,9), 3) should be(Array(-1,-1))
    t.twoSum(Array(1,3,4,6,8,9), 2) should be(Array(-1,-1))
    t.twoSum(Array(1,3,4,6,8,9), 1) should be(Array(-1,-1))
    t.twoSum(Array(1,3,4,6,8,9), -1) should be(Array(-1,-1))
  }
}
