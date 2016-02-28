package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LargestNumberTest extends FunSuite with ShouldMatchers {
  val l = new LargestNumber

  test("should work") {
    l.largestNumber(Array(0, 0)) should be("0")
    l.largestNumber(Array(30, 30)) should be("3030")
    l.largestNumber(Array(0, 30)) should be("300")
    l.largestNumber(Array(3, 30)) should be("330")
    l.largestNumber(Array(33, 330)) should be("33330")
    l.largestNumber(Array(33, 330,5,62,78)) should be("7862533330")
    l.largestNumber(Array(3553, 355,5,62,78)) should be("786253553553")
  }
}
