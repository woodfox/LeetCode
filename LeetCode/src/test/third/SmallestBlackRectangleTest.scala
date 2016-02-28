package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SmallestBlackRectangleTest extends FunSuite with ShouldMatchers {
  val t = new SmallestBlackRectangle

  test("BFS version should work") {
    t.minArea(Array("0010","0110","0100").map(_.toCharArray), 0, 2) should be(6)
    t.minArea(Array("0000","0110","0100").map(_.toCharArray), 1, 2) should be(4)
    t.minArea(Array("0000","0100","0100").map(_.toCharArray), 1, 1) should be(2)
    t.minArea(Array("0111","0100","0100").map(_.toCharArray), 0, 2) should be(9)
  }

}
