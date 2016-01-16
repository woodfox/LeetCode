package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.JavaConversions._

class GrayCodeTest extends FunSuite with ShouldMatchers {
  val g = new GrayCode

  test("Should work") {
    g.grayCode(1).toList should be(List(0, 1))
    g.grayCode(2).toList should be(List(0, 1, 3, 2))
    g.grayCode(3).toList should be(List(0, 1, 3, 2, 6, 7, 5, 4))
  }

}
