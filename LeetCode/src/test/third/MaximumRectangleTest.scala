package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumRectangleTest extends FunSuite with ShouldMatchers {
  val m = new MaximumRectangle

  test("should work") {
    val array = Array(
      Array('0','1','1','1','0'),
      Array('1','0','1','1','1'),
      Array('0','0','0','0','1'),
      Array('1','1','1','0','1'),
      Array('1','1','1','0','0'),
      Array('1','1','0','0','0')
    )
    m.maximalRectangle(array) should be(6)

    m.maximalRectangle(Array(Array('0', '1'), Array('1', '0'))) should be(1)
  }

}
