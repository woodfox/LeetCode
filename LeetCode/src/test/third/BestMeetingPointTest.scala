package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class BestMeetingPointTest extends FunSuite with ShouldMatchers {
  val t = new BestMeetingPoint

  test("should work") {
    t.minTotalDistance(Array(Array(1,0,0,0,0),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(4)
    t.minTotalDistance(Array(Array(1,0,0,0,0),Array(0,0,0,0,0),Array(0,0,1,0,1))) should be(6)
    t.minTotalDistance(Array(Array(1,0,0,0,0),Array(0,0,0,0,1),Array(0,0,1,0,0))) should be(6)
    t.minTotalDistance(Array(Array(1,0,0,0,1),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(6)
  }

  test("slow version should work") {
    t.minTotalDistance_slow(Array(Array(1,0,0,0,0),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(4)
    t.minTotalDistance_slow(Array(Array(1,0,0,0,0),Array(0,0,0,0,0),Array(0,0,1,0,1))) should be(6)
    t.minTotalDistance_slow(Array(Array(1,0,0,0,0),Array(0,0,0,0,1),Array(0,0,1,0,0))) should be(6)
    t.minTotalDistance_slow(Array(Array(1,0,0,0,1),Array(0,0,0,0,0),Array(0,0,1,0,0))) should be(6)
  }
}
