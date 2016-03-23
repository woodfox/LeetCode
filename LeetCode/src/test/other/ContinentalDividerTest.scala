package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ContinentalDividerTest extends FunSuite with ShouldMatchers {
  val t = new ContinentalDivider

  test("should work") {
    t.find(Array(
      Array(0,0,0,1,2,3,0),
      Array(0,1,2,2,4,3,2),
      Array(2,1,1,3,3,2,0),
      Array(0,3,3,3,2,3,3))).toList should be(List(4))

    t.find(Array(
      Array(0,0,0,1,2,3,0),
      Array(0,1,2,2,4,3,2),
      Array(2,1,1,3,5,2,0),
      Array(0,3,3,3,2,3,3))).toList should be(List(5))

    t.find(Array(
      Array(0,0,0,1,2,4,0),
      Array(0,1,2,2,4,3,5),
      Array(2,1,1,3,3,2,0),
      Array(0,3,3,3,2,3,3))).toList should be(List())
  }
}
