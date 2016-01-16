package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ContainerWithMaxWaterTest extends FunSuite with ShouldMatchers {
  val c = new ContainerWithMaxWater()

  test("should calculate max area"){
    c.maxArea(Array(1, 2)) should be(1)
    c.maxArea(Array(1, 2, 3)) should be(2)
    c.maxArea(Array(1, 2, 3, 4)) should be(4)
    c.maxArea(Array(3, 2, 1)) should be(2)
    c.maxArea(Array(1, 2, 3, 2)) should be(4)
    c.maxArea(Array(1, 2, 1, 1, 4)) should be(6)
  }
}
