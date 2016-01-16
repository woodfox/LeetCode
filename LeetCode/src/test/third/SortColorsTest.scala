package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SortColorsTest extends FunSuite with ShouldMatchers {
  val s = new SortColors

  test("should work"){
    val array = Array(0)
    s.sortColors(array)
    array should be(Array(0))
  }

  test("should work for reversed order"){
    val array = Array(2,1,0)
    s.sortColors(array)

    array should be(Array(0,1,2))
  }

  test("should work for multiple order"){
    val array = Array(2,1,0,1,2,0)
    s.sortColors(array)

    array should be(Array(0,0,1,1,2,2))
  }

  test("should work for multiple order"){
    val array = Array(1,0)
    s.sortColors(array)

    array should be(Array(0,1))
  }
}
