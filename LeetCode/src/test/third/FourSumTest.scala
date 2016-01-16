package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class FourSumTest extends FunSuite with ShouldMatchers {
  val f = new FourSum

  test("should return list of four sum results") {
    convert(f.fourSum(Array(3,1,2), 7)) should be(List())
    convert(f.fourSum(Array(3,1,2,1,3,2,1,2,3), 7)) should be(List(List(1,1,2,3), List(1,2,2,2)))
    convert(f.fourSum(Array(3,1,2,1,3,2,1,2,3), 6)) should be(List(List(1,1,1,3), List(1,1,2,2)))
    convert(f.fourSum(Array(3,1,2,1,3,2,1,2,3), 8)) should be(List(List(1,1,3,3), List(1,2,2,3)))
    convert(f.fourSum(Array(3,1,2,1,3,2,1,2,3), 10)) should be(List(List(1,3,3,3), List(2,2,3,3)))
    convert(f.fourSum(Array(0, 1, -1, 0, -2, 2), 0)) should be(List(List(-2, -1, 1, 2), List(-2, 0, 0, 2), List(-1,0,0,1)))
  }

  def convert(array: java.util.List[java.util.List[Integer]]) = {
    array.asScala.map(_.asScala.toList).toList
  }
}
