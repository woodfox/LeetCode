package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RomanToIntegerTest extends FunSuite with ShouldMatchers {
  val r = new RomanToInteger()

  test("Should convert roman to integer") {
    r.romanToInt("I") should be(1)
    r.romanToInt("II") should be(2)
    r.romanToInt("III") should be(3)
    r.romanToInt("IV") should be(4)
    r.romanToInt("V") should be(5)
    r.romanToInt("VI") should be(6)
    r.romanToInt("VII") should be(7)
    r.romanToInt("VIII") should be(8)
    r.romanToInt("IX") should be(9)
    r.romanToInt("X") should be(10)
    r.romanToInt("XI") should be(11)
    r.romanToInt("XII") should be(12)
    r.romanToInt("XXXVII") should be(37)
    r.romanToInt("XXXIX") should be(39)
    r.romanToInt("XLII") should be(42)
    r.romanToInt("XLIV") should be(44)
    r.romanToInt("XCIII") should be(93)
    r.romanToInt("XCIV") should be(94)
    r.romanToInt("XCIX") should be(99)
    r.romanToInt("DXXX") should be(530)
    r.romanToInt("DCCVII") should be(707)
    r.romanToInt("CM") should be(900)
    r.romanToInt("MD") should be(1500)
  }
}
