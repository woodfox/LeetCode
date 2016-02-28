package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ConnectedComponentsInGraphTest extends FunSuite with ShouldMatchers {
  val t = new ConnectedComponentsInGraph

  test("should work") {
    t.connectedComponents(0, Array()) should be(0)
    t.connectedComponents(1, Array()) should be(1)
    t.connectedComponents(2, Array()) should be(2)
    t.connectedComponents(2, Array(Array(0,1))) should be(1)
    t.connectedComponents(3, Array(Array(0,1))) should be(2)
    t.connectedComponents(3, Array(Array(0,1),Array(1,2),Array(2,0))) should be(1)
    t.connectedComponents(4, Array(Array(0,1),Array(1,2),Array(2,0))) should be(2)
    t.connectedComponents(4, Array(Array(0,1),Array(2,3))) should be(2)
    t.connectedComponents(5, Array(Array(0,1),Array(1,3), Array(3,4))) should be(2)
  }
}
