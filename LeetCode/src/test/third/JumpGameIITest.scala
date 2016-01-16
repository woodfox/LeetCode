package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class JumpGameIITest extends FunSuite with ShouldMatchers {
  val j = new JumpGameII

  test("should calculate minimum jump") {
    j.jump(Array()) should be(0)
    j.jump(Array(1)) should be(0)
    j.jump(Array(1,2)) should be(1)
    j.jump(Array(2,2,1,1,4)) should be(3)
    j.jump(Array(2,2,1,0,4)) should be(Integer.MAX_VALUE)
    j.jump(Array(2, 3, 1, 1, 4)) should be(2)
  }
}
