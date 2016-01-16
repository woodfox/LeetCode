package third

import java.util

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class ThreeSumTest extends FunSuite with ShouldMatchers {
  val t = new ThreeSum

  test("Should return unique set") {
    convert(t.threeSum(Array())) should be(Set())
    convert(t.threeSum(Array(-1, 1))) should be(Set())
    convert(t.threeSum(Array(-1, 1, 0))) should be(Set(List(-1,0,1)))
    convert(t.threeSum(Array(-1, 0, 1, 2, -1, -4))) should be(Set(List(-1,0,1), List(-1,-1,2)))
    convert(t.threeSum(Array(-1, 0, -1, 0, 1, 1))) should be(Set(List(-1,0,1)))
    convert(t.threeSum(Array(-1, 0, -1, 0, 1, 1, 2))) should be(Set(List(-1,0,1), List(-1,-1,2)))
    convert(t.threeSum(Array(0, 0, 0, 0, 1, 1, 1))) should be(Set(List(0, 0, 0)))
  }

  def convert(array: util.List[util.List[Integer]]) = {
    array.asScala.map(_.asScala.toList).toSet
  }
}
