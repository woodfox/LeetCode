package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.JavaConverters._

class PascalTriangleIITest extends FunSuite with ShouldMatchers {
  val p = new PascalTriangleII

  test("should work") {
    p.getRow(0).asScala.toList should be(List(1))
    p.getRow(1).asScala.toList should be(List(1,1))
    p.getRow(2).asScala.toList should be(List(1,2,1))
    p.getRow(3).asScala.toList should be(List(1,3,3,1))
    p.getRow(4).asScala.toList should be(List(1,4,6,4,1))
    p.getRow(5).asScala.toList should be(List(1,5,10,10,5,1))
  }
}
