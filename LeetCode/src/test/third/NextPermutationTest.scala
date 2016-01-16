package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class NextPermutationTest extends FunSuite with ShouldMatchers {
  val n = new NextPermutation

  test("should find next larger number with one element") {
    val a = Array(1)
    n.nextPermutation(a)
    a should be(Array(1))
  }
  test("should find next larger number with two elements") {
    val a = Array(1, 2)
    n.nextPermutation(a)
    a should be(Array(2, 1))
  }
  test("should find next larger number with three") {
    val a = Array(1, 3, 2)
    n.nextPermutation(a)
    a should be(Array(2,1,3))
  }
  test("should find next larger number with multiple") {
    val a = Array(1, 2, 8, 2, 6, 6, 5, 5, 3)
    n.nextPermutation(a)
    a should be(Array(1, 2, 8, 3, 2, 5, 5, 6, 6))
  }
  test("should find next larger number with four") {
    val a = Array(1, 2, 3, 5)
    n.nextPermutation(a)
    a should be(Array(1, 2, 5, 3))
  }
  test("should find next larger number with sequence") {
    val a = Array(1, 2, 3, 5, 4)
    n.nextPermutation(a)
    a should be(Array(1, 2, 4, 3, 5))
  }
  test("should find next larger number with reverse sorted"){
    val a = Array(5,4,3,2,1)
    n.nextPermutation(a)
    a should be(Array(1,2,3,4,5))
  }
}
