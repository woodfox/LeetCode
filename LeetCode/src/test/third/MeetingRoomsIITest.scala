package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.Interval
import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class MeetingRoomsIITest extends FunSuite with ShouldMatchers {
  val m = new MeetingRoomsII

  test("should work") {
    m.minMeetingRooms(ListBuffer(new Interval(1,6))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(7,9))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(7,9), new Interval(9,10))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(5,9), new Interval(9,10))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(4,9), new Interval(5,6))) should be(3)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(6,7),new Interval(4,9))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(0,30),new Interval(15,20),new Interval(5,10),new Interval(35,60))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(0,30),new Interval(5,25),new Interval(15,20),new Interval(25,30))) should be(3)
  }

  test("simple version should work") {
    m.minMeetingRooms(ListBuffer(new Interval(1,6))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(7,9))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(7,9), new Interval(9,10))) should be(1)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(5,9), new Interval(9,10))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(4,9), new Interval(5,6))) should be(3)
    m.minMeetingRooms(ListBuffer(new Interval(1,6),new Interval(6,7),new Interval(4,9))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(0,30),new Interval(15,20),new Interval(5,10),new Interval(35,60))) should be(2)
    m.minMeetingRooms(ListBuffer(new Interval(0,30),new Interval(5,25),new Interval(15,20),new Interval(25,30))) should be(3)
  }
}
