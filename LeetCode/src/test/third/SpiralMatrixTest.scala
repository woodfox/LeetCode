package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class SpiralMatrixTest extends FunSuite with ShouldMatchers {
  val s = new SpiralMatrix

  test("should print by order") {
    s.spiralOrder(Array(Array(1))).asScala.toList should be(List(1))
    s.spiralOrder(Array(Array(1,2,3))).asScala.toList should be(List(1,2,3))
    s.spiralOrder(Array(Array(1),Array(2),Array(3))).asScala.toList should be(List(1,2,3))
    s.spiralOrder(Array(Array(1,2),Array(3,4),Array(5,6))).asScala.toList should be(List(1,2,4,6,5,3))
    s.spiralOrder(Array(Array(1,2),Array(3,4),Array(5,6),Array(7,8))).asScala.toList should be(List(1,2,4,6,8,7,5,3))
    s.spiralOrder(Array(Array(1,2,3,4),Array(5,6,7,8))).asScala.toList should be(List(1,2,3,4,8,7,6,5))
    s.spiralOrder(Array(Array(1,2,3,4),Array(5,6,7,8),Array(9,10,11,12))).asScala.toList should be(List(1,2,3,4,8,12,11,10,9,5,6,7))
    s.spiralOrder(Array(Array(1,2,3),Array(4,5,6),Array(7,8,9))).asScala.toList should be(List(1,2,3,6,9,8,7,4,5))
    s.spiralOrder(Array(Array(1,2,3),Array(4,5,6),Array(7,8,9),Array(10,11,12))).asScala.toList should be(List(1,2,3,6,9,12,11,10,7,4,5,8))
  }
}
