package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ShortestBuildingDistanceTest extends FunSuite with ShouldMatchers {
  val t = new ShortestBuildingDistance

  test("should work") {
    t.shortestDistance(Array(Array(1,0,0,2,0,0,1))) should be(-1)
    t.shortestDistance(Array(Array(1,0,0,0,0,0,1))) should be(6)
    t.shortestDistance(Array(Array(1,0,0,0,0,1))) should be(5)
    t.shortestDistance(Array(Array(1,0,2,0,1),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(7)
    t.shortestDistance(Array(Array(1,0,2,0,1),Array(0,0,2,0,0),Array(0,0,1,0,0))) should be(-1)
    t.shortestDistance(Array(Array(1,0,2,0,0),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(4)
    t.shortestDistance(Array(Array(1,0,2,0,1),Array(0,0,0,0,0),Array(0,0,0,0,0))) should be(6)
    t.shortestDistance(Array(Array(1,0,2,0,1),Array(0,0,2,0,0),Array(0,0,0,0,0))) should be(8)
  }

  test("simple version should work") {
    t.shortestDistance_simple(Array(Array(1,0,0,2,0,0,1))) should be(-1)
    t.shortestDistance_simple(Array(Array(1,0,0,0,0,0,1))) should be(6)
    t.shortestDistance_simple(Array(Array(1,0,0,0,0,1))) should be(5)
    t.shortestDistance_simple(Array(Array(1,0,2,0,1),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(7)
    t.shortestDistance_simple(Array(Array(1,0,2,0,1),Array(0,0,2,0,0),Array(0,0,1,0,0))) should be(-1)
    t.shortestDistance_simple(Array(Array(1,0,2,0,0),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(4)
    t.shortestDistance_simple(Array(Array(1,0,2,0,1),Array(0,0,0,0,0),Array(0,0,0,0,0))) should be(6)
    t.shortestDistance_simple(Array(Array(1,0,2,0,1),Array(0,0,2,0,0),Array(0,0,0,0,0))) should be(8)
  }
}
