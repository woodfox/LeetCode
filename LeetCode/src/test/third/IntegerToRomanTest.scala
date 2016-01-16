package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class IntegerToRomanTest extends FunSuite  with ShouldMatchers {
  val i = new IntegerToRoman

  test("should convert number to roman string") {
    i.intToRoman(1) should be("I")
    i.intToRoman(2) should be("II")
    i.intToRoman(3) should be("III")
    i.intToRoman(4) should be("IV")
    i.intToRoman(5) should be("V")
    i.intToRoman(6) should be("VI")
    i.intToRoman(7) should be("VII")
    i.intToRoman(8) should be("VIII")
    i.intToRoman(9) should be("IX")
    i.intToRoman(10) should be("X")
    i.intToRoman(11) should be("XI")
    i.intToRoman(12) should be("XII")
    i.intToRoman(37) should be("XXXVII")
    i.intToRoman(39) should be("XXXIX")
    i.intToRoman(42) should be("XLII")
    i.intToRoman(44) should be("XLIV")
    i.intToRoman(45) should be("XLV")
    i.intToRoman(49) should be("XLIX")
    i.intToRoman(56) should be("LVI")
    i.intToRoman(62) should be("LXII")
    i.intToRoman(81) should be("LXXXI")
    i.intToRoman(90) should be("XC")
    i.intToRoman(93) should be("XCIII")
    i.intToRoman(94) should be("XCIV")
    i.intToRoman(99) should be("XCIX")
    i.intToRoman(530) should be("DXXX")
    i.intToRoman(707) should be("DCCVII")
    i.intToRoman(900) should be("CM")
    i.intToRoman(1500) should be("MD")
  }
}
