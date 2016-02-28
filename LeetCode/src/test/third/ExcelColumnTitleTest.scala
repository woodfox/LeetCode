package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ExcelColumnTitleTest extends FunSuite with ShouldMatchers {
  val e = new ExcelColumnTitle

  test("should work") {
    e.convertToTitle(1) should be("A")
    e.convertToTitle(3) should be("C")
    e.convertToTitle(25) should be("Y")
    e.convertToTitle(26) should be("Z")
    e.convertToTitle(27) should be("AA")
    e.convertToTitle(28) should be("AB")
    e.convertToTitle(29) should be("AC")
    e.convertToTitle(51) should be("AY")
    e.convertToTitle(52) should be("AZ")
    e.convertToTitle(53) should be("BA")
    e.convertToTitle(54) should be("BB")
    e.convertToTitle(78) should be("BZ")
    e.convertToTitle(79) should be("CA")
    e.convertToTitle(703) should be("AAA")
  }
}
