package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.mutable.ListBuffer

class PlusOneTest extends FunSuite with ShouldMatchers {
  val p = new PlusOne

  test("should plus one in the result"){
    p.plusOne(Array(0)) should be(Array(1))
    p.plusOne(Array(1)) should be(Array(2))
    p.plusOne(Array(9)) should be(Array(1,0))
    p.plusOne(Array(1,9)) should be(Array(2,0))
    p.plusOne(Array(1,9,9)) should be(Array(2,0,0))
    p.plusOne(Array(9,9,9)) should be(Array(1,0,0,0))
  }

  test("scalaVersion should plus one in the result"){
    scalaPlusOne(Array(0)) should be(Array(1))
    scalaPlusOne(Array(1)) should be(Array(2))
    scalaPlusOne(Array(9)) should be(Array(1,0))
    scalaPlusOne(Array(1,9)) should be(Array(2,0))
    scalaPlusOne(Array(1,9,9)) should be(Array(2,0,0))
    scalaPlusOne(Array(9,9,9)) should be(Array(1,0,0,0))
  }

  def scalaPlusOne(digits: Array[Int]): Array[Int] ={
    val result = ListBuffer[Int]()
    val addOn = digits.foldRight(1) { case (num, addOn) =>
      val sum = num + addOn
      result += sum%10
      sum/10
    }
    if(addOn > 0) result += addOn

    result.toArray.reverse
  }
}
