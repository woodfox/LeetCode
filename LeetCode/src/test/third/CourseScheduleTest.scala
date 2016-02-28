package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CourseScheduleTest extends FunSuite with ShouldMatchers {
  val c = new CourseSchedule

  test("should work") {
    c.canFinish(3, Array(Array(1,0),Array(2,1))) should be(true)

    c.canFinish(2, Array(Array(0,1))) should be(true)
    c.canFinish(2, Array(Array(1,0))) should be(true)
    c.canFinish(3, Array(Array(1,0),Array(1,2))) should be(true)
    c.canFinish(3, Array(Array(1,0),Array(1,2),Array(0,2))) should be(true)
    c.canFinish(3, Array(Array(1,0),Array(0,2),Array(2,1))) should be(false)
    c.canFinish(2, Array(Array(1,0), Array(0,1))) should be(false)
  }
}
