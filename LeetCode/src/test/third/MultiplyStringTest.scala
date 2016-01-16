package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class MultiplyStringTest extends FunSuite with ShouldMatchers {
  val m = new MultiplyString

  test("should multiple two strings") {
    m.multiply("", "123") should be("")
    m.multiply("0", "123") should be("0")
    m.multiply("1", "123") should be("123")
    m.multiply("321", "1") should be("321")
    m.multiply("999", "3") should be("2997")
    m.multiply("999", "0") should be("0")
    m.multiply("999", "13") should be(s"${999*13}")
    m.multiply("999", "99999") should be(s"${999*99999}")
    m.multiply("99999998999", "0000001") should be("99999998999")
    m.multiply("123456789", "1000000") should be("123456789000000")
    m.multiply("123456", "21") should be("2592576")
  }

  test("trimLeftZero should trim left zero"){
    m.trimLeftZero("0000012345") should be("12345")
    m.trimLeftZero("12345") should be("12345")
    m.trimLeftZero("0000000000") should be("0")
    m.trimLeftZero("0000009000") should be("9000")
  }

  test("addString should add two string"){
    m.addString("123", "45") should be("168")
    m.addString("123", "1") should be("124")
    m.addString("999", "4") should be("1003")
    m.addString("123", "888") should be("1011")
  }

  test("multiplyDigit should multiple string with one digit"){
    m.multiplyDigit("1234", '0', 0) should be("0")
    m.multiplyDigit("1234", '2', 2) should be("246800")
    m.multiplyDigit("1234", '1', 2) should be("123400")
    m.multiplyDigit("12", '9', 4) should be("1080000")
  }
}
