package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class SpiralMatrixIITest extends FunSuite with ShouldMatchers {
  val s = new SpiralMatrixII

  test("Should generate matrix") {
    s.generateMatrix(1) should be(Array(Array(1)))
    s.generateMatrix(2) should be(Array(Array(1,2), Array(4,3)))
    s.generateMatrix(3) should be(Array(Array(1,2,3), Array(8,9,4), Array(7,6,5)))
    s.generateMatrix(4) should be(Array(Array(1,2,3,4), Array(12,13,14,5), Array(11,16,15,6),Array(10,9,8,7)))
  }
}
