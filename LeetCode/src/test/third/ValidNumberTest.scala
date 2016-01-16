package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ValidNumberTest extends FunSuite with ShouldMatchers {
  val v = new ValidNumber

  test("should validate if it's number"){
    v.isNumber("+2e0") should be(true)
    v.isNumber("") should be(false)
    v.isNumber("  ") should be(false)
    v.isNumber("12 .45 ") should be(false)
    v.isNumber("aa") should be(false)
    v.isNumber("1a ") should be(false)
    v.isNumber("1e ") should be(false)
    v.isNumber("e100 ") should be(false)
    v.isNumber("1eab ") should be(false)
    v.isNumber("2e100e4") should be(false)
    v.isNumber("2.00.99") should be(false)
    v.isNumber("+-12") should be(false)
    v.isNumber("+eo") should be(false)
    v.isNumber("2.4e5.6") should be(false)
    v.isNumber("12") should be(true)
    v.isNumber("12.") should be(true)
    v.isNumber(".12") should be(true)
    v.isNumber(".") should be(false)
    v.isNumber("4e+") should be(false)
    v.isNumber(" 12 ") should be(true)
    v.isNumber("12.45 ") should be(true)
    v.isNumber("12.45e10") should be(true)
    v.isNumber(" 12.45 e 10 ") should be(false)
    v.isNumber("12e19.12") should be(false)
    v.isNumber("-2e+2") should be(true)
    v.isNumber("+12e-0") should be(true)
    v.isNumber("12.12345678") should be(true)
  }
}
