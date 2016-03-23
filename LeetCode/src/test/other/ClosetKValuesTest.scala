package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ClosetKValuesTest extends FunSuite with ShouldMatchers {
  val t = new ClosetKValues

  test("should work") {
    t.findKCloset(Array(1,2,3,4,5,6,7,8), 0.2, 4).toList should be(List(1,2,3,4))
    t.findKCloset(Array(1,2,3,4,5,6,7,8), 10.2, 4).toList should be(List(5,6,7,8))
    t.findKCloset(Array(1,2,3,4,5,6,7,8), 7.2, 4).toList should be(List(5,6,7,8))
    t.findKCloset(Array(1,2,3,4,5,6,7,8), 4.2, 4).toList should be(List(3,4,5,6))
  }
}
