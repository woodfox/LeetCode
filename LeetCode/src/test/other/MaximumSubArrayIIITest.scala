package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaximumSubArrayIIITest extends FunSuite with ShouldMatchers {
  val t = new MaximumSubArrayIII

  test("max sub array should work") {
    t.maxSubArray(Array(-1,4,-2,3,-2,3), 1) should be(6)
    t.maxSubArray(Array(-1,4,-2,3,-2,3), 2) should be(8)
    t.maxSubArray(Array(-1,4,-2,3,-2,3), 3) should be(10)
    t.maxSubArray(Array(-1,4,-2,3,-2,3), 4) should be(9)
    t.maxSubArray(Array(-1,-2,-3,-100,-1,-50), 2) should be(-2)
    t.maxSubArray(Array(-45,74,-14,65,-12,73,-54,8,-8,2,-4,91,-48,8,-94,98,-13,66,-36,24,-36,21,-82,86,-79,85,-90,28,-93,78,-12,65,-79,4,-50,24,-96,89,-9,80,-5,49,-54,3,-68,74,-36,43,-63,51,-97,87,-45,27,-2,96,-97,36,-7,43,-48,90,-67,80,-43,33,-68,76,-4,61,-73,34,-59,6,-96,72,-40,58,-92,44,-69,84,-94,64,-22,46,-10,88,-34,11,-15,38,-62,59,-100,50,-38,20,-45,25,-9,42,-24,94,-19,69,-86,100,-30,78,-27,82,-79,40,-77,90,-7,1,-59,67,-56,80,-99,71,-4,83,-60,9,-3,9,-1,4,-66,22,-23,70,-36,44,-58,17), 102) should be(3106)
  }
}
