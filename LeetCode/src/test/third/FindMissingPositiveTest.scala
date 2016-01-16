package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FindMissingPositiveTest extends FunSuite with ShouldMatchers {
  val f = new FindMissingPositive

  test("should find missing positive"){
    f.firstMissingPositive(Array(-3,3,2,4,1)) should be(5)
    f.firstMissingPositive(Array(-3,3,6,4,1)) should be(2)
    f.firstMissingPositive(Array(-3,3,2,4,0)) should be(1)
    f.firstMissingPositive(Array(9,3,5,2,1)) should be(4)
    f.firstMissingPositive(Array(-3,0,9,4,3)) should be(1)
    f.firstMissingPositive(Array(-3,-3,-2,-4,1)) should be(2)
    f.firstMissingPositive(Array(-3)) should be(1)
    f.firstMissingPositive(Array(0)) should be(1)
    f.firstMissingPositive(Array(1)) should be(2)
    f.firstMissingPositive(Array(2)) should be(1)
  }

  test("scalaWay should find missing positive"){
    scalaFindMissingPositive(Array(-3,3,2,4,1)) should be(5)
    scalaFindMissingPositive(Array(-3,3,6,4,1)) should be(2)
    scalaFindMissingPositive(Array(-3,3,2,4,0)) should be(1)
    scalaFindMissingPositive(Array(9,3,5,2,1)) should be(4)
    scalaFindMissingPositive(Array(-3,0,9,4,3)) should be(1)
    scalaFindMissingPositive(Array(-3,-3,-2,-4,1)) should be(2)
    scalaFindMissingPositive(Array(-3)) should be(1)
    scalaFindMissingPositive(Array(0)) should be(1)
    scalaFindMissingPositive(Array(1)) should be(2)
    scalaFindMissingPositive(Array(2)) should be(1)
  }

  def scalaFindMissingPositive(a: Array[Int]): Int = {
    val n = a.length
    val b = a.filter(v => v>0 && v<=n)
    for(i <- 0 to b.length -1 ) {
      val v = Math.abs(b(i))
      b(v-1) = Math.abs(b(v-1)) * (-1)
    }
    for(i <- 0 to b.length -1 ) {
      if(b(i) > 0) return i+1;
    }

    b.length
  }
}
