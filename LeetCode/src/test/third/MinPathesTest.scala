package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MinPathesTest extends FunSuite with ShouldMatchers {
  val t = new MinPathes

  test("should work") {
    t.minPatches(Array(1,3), 6) should be(1)
    t.minPatches(Array(1,2,2), 5) should be(0)
    t.minPatches(Array(1,5,10), 20) should be(2)
    t.minPatches(Array(1,2,31,33), 2147483647) should be(28)
  }
}
