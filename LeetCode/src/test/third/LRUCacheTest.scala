package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LRUCacheTest extends FunSuite with ShouldMatchers {
  val l = new LRUCache(4)
  test("should work") {
    l.get(10) should be(-1)

    l.set(1, 10)
    l.set(2, 20)
    l.get(3) should be(-1)
    l.get(1) should be(10)

    l.set(3, 30)
    l.set(4, 40)
    l.set(5, 50)
    // Now is 5,4,3,1  (2 is removed as least used)
    l.get(2) should be(-1)
    l.get(1) should be(10)
    l.get(3) should be(30)
    l.get(5) should be(50)
    l.get(4) should be(40)

    // Now is 4,5,3,1
    l.set(6, 60)
    l.get(1) should be(-1)
    l.get(6) should be(60)
  }
}
