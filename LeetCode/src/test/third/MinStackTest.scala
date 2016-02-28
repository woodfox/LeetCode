package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MinStackTest extends FunSuite with ShouldMatchers {
  val m = new MinStack

  test("Should work") {
    m.push(3)
    m.top() should be(3)
    m.getMin() should be(3)

    m.push(5)
    m.top() should be(5)
    m.getMin() should be(3)

    m.push(2)
    m.top() should be(2)
    m.getMin() should be(2)

    m.push(8)
    m.top() should be(8)
    m.getMin should be(2)

    m.push(-1)
    m.top() should be(-1)
    m.getMin should be(-1)

    m.pop()
    m.top() should be(8)
    m.getMin should be(2)

    m.pop()
    m.top() should be(2)
    m.getMin should be(2)

    m.pop()
    m.top() should be(5)
    m.getMin should be(3)

    m.pop()
    m.top() should be(3)
    m.getMin should be(3)
  }
}
