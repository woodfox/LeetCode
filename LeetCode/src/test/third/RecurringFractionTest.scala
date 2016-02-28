package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RecurringFractionTest extends FunSuite with ShouldMatchers {
  val r = new RecurringFraction

  test("should work") {
    r.fractionToDecimal(-2, 3) should be("-0.(6)")
    r.fractionToDecimal(9, -101) should be("-0.(0891)")
    r.fractionToDecimal(-1, -7) should be("0.(142857)")
    r.fractionToDecimal(-11, 7) should be("-1.(571428)")

    r.fractionToDecimal(2, 3) should be("0.(6)")
    r.fractionToDecimal(20, 3) should be("6.(6)")

    r.fractionToDecimal(1, 3) should be("0.(3)")

    r.fractionToDecimal(9, 101) should be("0.(0891)")
    r.fractionToDecimal(90, 101) should be("0.(8910)")
    r.fractionToDecimal(900, 101) should be("8.(9108)")
    r.fractionToDecimal(9000, 101) should be("89.(1089)")
    r.fractionToDecimal(90000, 101) should be("891.(0891)")

    r.fractionToDecimal(1, 7) should be("0.(142857)")
    r.fractionToDecimal(10, 7) should be("1.(428571)")
    r.fractionToDecimal(100, 7) should be("14.(285714)")

    r.fractionToDecimal(11, 7) should be("1.(571428)")
    r.fractionToDecimal(110, 7) should be("15.(714285)")

    r.fractionToDecimal(-1, -2147483648) should be("0.0000000004656612873077392578125")
    r.fractionToDecimal(2147483647, 1) should be("2147483647")
    r.fractionToDecimal(-2147483648, 1) should be("-2147483648")
  }

}
