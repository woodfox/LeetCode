package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class NumberofIslandsTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val n = new NumberofIslands
    n.numIslands(Array("1100".toCharArray, "0110".toCharArray, "0001".toCharArray, "1000".toCharArray)) should be(3)
    n.numIslands(Array("1100".toCharArray, "0110".toCharArray, "0001".toCharArray)) should be(2)
    n.numIslands(Array("1100".toCharArray, "0110".toCharArray, "0111".toCharArray)) should be(1)
    n.numIslands(Array("1100".toCharArray, "0110".toCharArray, "0101".toCharArray)) should be(2)
    n.numIslands(Array("1111".toCharArray, "1111".toCharArray, "1111".toCharArray)) should be(1)
    n.numIslands(Array("0000".toCharArray, "0000".toCharArray, "0000".toCharArray)) should be(0)
  }
}
