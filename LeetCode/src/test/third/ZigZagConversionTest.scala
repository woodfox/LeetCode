package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ZigZagConversionTest extends FunSuite with ShouldMatchers {
  val instance = new ZigZagConversion()

  test("convert should generate correct result") {
    instance.convert(null, 1) should be(null)
    instance.convert("", 1) should be("")
    instance.convert("ABC", 1) should be("ABC")
    instance.convert("ABCDEFG", 2) should be("ACEGBDF")
    instance.convert("ABCDEFG", 3) should be("AEBDFCG")
    instance.convert("ABCDEFG", 4) should be("AGBFCED")
    instance.convert("ABCDEFG", 5) should be("ABCGDFE")
    instance.convert("ABCDEFG", 6) should be("ABCDEGF")
    instance.convert("ABCDEFG", 7) should be("ABCDEFG")
    instance.convert("ABCDEFG", 10) should be("ABCDEFG")
    instance.convert("PAYPALISHIRING", 3) should be("PAHNAPLSIIGYIR")
  }
}
