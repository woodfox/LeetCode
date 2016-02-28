package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class GraphValidTreeTest extends FunSuite with ShouldMatchers {
  val g = new GraphValidTree

  test("should work") {
    g.validTree(2, Array(Array(0,1))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(1,2),Array(1,3))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(0,2),Array(0,3))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(0,2),Array(2,3))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(0,2),Array(3,2))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(2,0),Array(3,0))) should be(true)
    g.validTree(4, Array(Array(0,1),Array(3,2),Array(3,1))) should be(true)
    g.validTree(5, Array(Array(0,1),Array(0,2),Array(3,4),Array(4,2))) should be(true)
    g.validTree(5, Array(Array(0,1),Array(0,2),Array(3,4),Array(4,0))) should be(true)
    g.validTree(5, Array(Array(0,1),Array(4,2),Array(3,4),Array(4,0))) should be(true)

    g.validTree(4, Array(Array(0,1),Array(1,2),Array(2,2))) should be(false)
    g.validTree(3, Array(Array(0,1))) should be(false)
    g.validTree(3, Array(Array(0,1))) should be(false)
    g.validTree(2, Array()) should be(false)
    g.validTree(5, Array(Array(0,1),Array(1,2),Array(2,0),Array(3,4))) should be(false)
    g.validTree(5, Array(Array(0,1),Array(1,2),Array(2,3),Array(3,4),Array(4,0))) should be(false)
  }
}
