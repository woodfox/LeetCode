package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WallsAndGatesTest extends FunSuite with ShouldMatchers {
  val t = new WallsAndGates

  test("should work") {
    val m = Integer.MAX_VALUE
    val a = Array(Array(m,-1,0,m),Array(m,m,m,-1),Array(m,-1,m,-1),Array(0,-1,m,m))
    t.wallsAndGates(a)
    a should be(Array(Array(3,-1,0,1),Array(2,2,1,-1),Array(1,-1,2,-1),Array(0,-1,3,4)))
  }

  test("should work if unreachable") {
    val m = Integer.MAX_VALUE
    val a = Array(Array(m,-1,0,m),Array(-1,m,m,-1),Array(m,-1,m,-1),Array(0,-1,-1,m))
    t.wallsAndGates(a)
    a should be(Array(Array(m,-1,0,1),Array(-1,2,1,-1),Array(1,-1,2,-1),Array(0,-1,-1,m)))
  }

  test("bfs should work") {
    val m = Integer.MAX_VALUE
    val a = Array(Array(m,-1,0,m),Array(m,m,m,-1),Array(m,-1,m,-1),Array(0,-1,m,m))
    t.wallsAndGates(a)
    a should be(Array(Array(3,-1,0,1),Array(2,2,1,-1),Array(1,-1,2,-1),Array(0,-1,3,4)))
  }

  test("bfs should work if unreachable") {
    val m = Integer.MAX_VALUE
    val a = Array(Array(m,-1,0,m),Array(-1,m,m,-1),Array(m,-1,m,-1),Array(0,-1,-1,m))
    t.wallsAndGates(a)
    a should be(Array(Array(m,-1,0,1),Array(-1,2,1,-1),Array(1,-1,2,-1),Array(0,-1,-1,m)))
  }
}
