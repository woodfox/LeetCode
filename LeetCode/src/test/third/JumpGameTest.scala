package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class JumpGameTest extends FunSuite with ShouldMatchers{
  val j = new JumpGame

  test("should judge if it can jump to end"){
    j.canJump(Array(0)) should be(true)
    j.canJump(Array(0,1)) should be(false)
    j.canJump(Array(1,2)) should be(true)
    j.canJump(Array(2,1,1,0,2)) should be(false)
    j.canJump(Array(2,3,1,1,4)) should be(true)
    j.canJump(Array(3,2,1,0,4)) should be(false)
  }

}
