package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ExcelColumnNumberTest extends FunSuite with ShouldMatchers {
  val e = new ExcelColumnNumber

  test("should work") {
    e.titleToNumber("A") should be(1)
    e.titleToNumber("C") should be(3)
    e.titleToNumber("Z") should be(26)
    e.titleToNumber("AA") should be(27)
    e.titleToNumber("AB") should be(28)
    e.titleToNumber("AZ") should be(52)
    e.titleToNumber("BA") should be(53)
    e.titleToNumber("BB") should be(54)
    e.titleToNumber("AAA") should be(703)
  }
}
