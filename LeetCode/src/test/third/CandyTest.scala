package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CandyTest extends FunSuite with ShouldMatchers {
  val c = new Candy

  test("should work") {
    c.candy(Array(1)) should be(1)
    c.candy(Array(10)) should be(1)
    c.candy(Array(10,10)) should be(2)
    c.candy(Array(4,3,2,2,3,4)) should be(12)
    c.candy(Array(1,2,2)) should be(4)
    c.candy(Array(1,2,2,3,4,5)) should be(13)
    c.candy(Array(10,5,10)) should be(5)
    c.candy(Array(10,5,10,4,6,8,10)) should be(15)
    c.candy(Array(1,2,3)) should be(6)
    c.candy(Array(1,2,3,2,1,0)) should be(13)
  }

}
