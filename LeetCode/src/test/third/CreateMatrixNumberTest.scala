package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CreateMatrixNumberTest extends FunSuite with ShouldMatchers {
  val t = new CreateMatrixNumber

  test("should work") {
    t.maxNumber(Array(3,4,6,5), Array(9,1,2,5,8,3), 1).toList should be(List(9))
    t.maxNumber(Array(3,4,6,5), Array(9,1,2,5,8,3), 2).toList should be(List(9,8))
    t.maxNumber(Array(3,4,6,5), Array(9,1,2,5,8,3), 3).toList should be(List(9,8,6))
    t.maxNumber(Array(3,4,6,5), Array(9,1,2,5,8,3), 4).toList should be(List(9,8,6,5))
    t.maxNumber(Array(3,4,6,5), Array(9,1,2,5,8,3), 5).toList should be(List(9,8,6,5,3))
    t.maxNumber(Array(6,7), Array(6,0,4), 1).toList should be(List(7))
    t.maxNumber(Array(6,7), Array(6,0,4), 2).toList should be(List(7,6))
    t.maxNumber(Array(6,7), Array(6,0,4), 3).toList should be(List(7,6,4))
    t.maxNumber(Array(6,7), Array(6,0,4), 4).toList should be(List(7,6,0,4))
    t.maxNumber(Array(6,7), Array(6,0,4), 5).toList should be(List(6,7,6,0,4))
    t.maxNumber(Array(3,9), Array(8,9), 3).toList should be(List(9,8,9))
  }
}
