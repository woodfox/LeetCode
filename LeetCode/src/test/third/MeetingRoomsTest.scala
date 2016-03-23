package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.Interval
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class MeetingRoomsTest extends FunSuite with ShouldMatchers {
  val m = new MeetingRooms

  test("should work") {
    m.canAttendMeetings(ListBuffer(new Interval(1,4))) should be(true)
    m.canAttendMeetings(ListBuffer(new Interval(1,4), new Interval(5,7))) should be(true)
    m.canAttendMeetings(ListBuffer(new Interval(1,4), new Interval(4,7))) should be(true)
    m.canAttendMeetings(ListBuffer(new Interval(8,10), new Interval(4,7))) should be(true)
    m.canAttendMeetings(ListBuffer(new Interval(8,10), new Interval(4,7), new Interval(8,9))) should be(false)
    m.canAttendMeetings(ListBuffer(new Interval(8,10), new Interval(4,9))) should be(false)
    m.canAttendMeetings(ListBuffer(new Interval(8,10), new Interval(4,12))) should be(false)
    m.canAttendMeetings(ListBuffer(new Interval(3,6), new Interval(4,12))) should be(false)
    m.canAttendMeetings(ListBuffer(new Interval(3,15), new Interval(4,12))) should be(false)
  }
}
