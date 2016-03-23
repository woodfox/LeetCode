package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.DisjointSet

class DisjointSetTest extends FunSuite with ShouldMatchers {
  val t = new DisjointSet(4)

  test("should work") {
    t.union(0,1)
    t.union(2,3)

    t.find(1) should be(0)
    t.find(3) should be(2)

    t.union(0, 3)

    t.find(0) should be(0)
    t.find(1) should be(0)
    t.find(2) should be(0)
    t.find(3) should be(0)
  }
}
