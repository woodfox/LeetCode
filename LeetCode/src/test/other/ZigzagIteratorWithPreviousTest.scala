package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ZigzagIteratorWithPreviousTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val t = new ZigzagIteratorWithPrevious(List(
      new ZigzagIteratorWithPrevious.CustomIterator[Integer](List[Integer](1,2,3)),
      new ZigzagIteratorWithPrevious.CustomIterator[Integer](List[Integer](4)),
      new ZigzagIteratorWithPrevious.CustomIterator[Integer](List[Integer](5,6))))

    t.hasPrevious should be(false)
    t.next should be(1)
    t.next should be(4)

    t.hasPrevious should be(true)
    t.previous
    t.next should be(4)

    t.next should be(5)
    t.next should be(2)
    t.previous
    t.previous
    t.next should be(5)
  }
}
