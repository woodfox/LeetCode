package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MaxQueueTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val m = new MaxQueue

    m.enqueue(1)
    m.enqueue(3)
    m.enqueue(7)
    m.enqueue(6)
    m.enqueue(3)
    m.enqueue(8)
    m.enqueue(7)
    m.enqueue(5)
    m.enqueue(6)

    m.max() should be(8)

    m.dequeue()
    m.dequeue()
    m.dequeue()
    m.max() should be(8)

    m.dequeue()
    m.dequeue()
    m.dequeue()
    m.max() should be(7)

    m.dequeue()
    m.max() should be(6)
  }
}
