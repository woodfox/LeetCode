package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.mutable.ArrayBuffer

class MaximunSubArrayTest extends FunSuite with ShouldMatchers {
  val m = new MaximunSubArray

  test("should find largest sum"){
    m.maxSubArray(Array()) should be(Integer.MIN_VALUE)
    m.maxSubArray(Array(-2)) should be(-2)
    m.maxSubArray(Array(-2,1)) should be(1)
    m.maxSubArray(Array(-2,1,2)) should be(3)
    m.maxSubArray(Array(-2,1,-1)) should be(1)
    m.maxSubArray(Array(-2,1,-2,3)) should be(3)
    m.maxSubArray(Array(-2,3,-2,3)) should be(4)
    m.maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4)) should be(6)
  }
}
