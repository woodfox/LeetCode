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

  test("convert with list should generate correct result") {
    instance.convert_withList("", 1) should be("")
    instance.convert_withList("ABCD", 3) should be("ABDC")
    instance.convert_withList("ABC", 1) should be("ABC")
    instance.convert_withList("ABCDEFG", 2) should be("ACEGBDF")
    instance.convert_withList("ABCDEFG", 3) should be("AEBDFCG")
    instance.convert_withList("ABCDEFG", 4) should be("AGBFCED")
    instance.convert_withList("ABCDEFG", 5) should be("ABCGDFE")
    instance.convert_withList("ABCDEFG", 6) should be("ABCDEGF")
    instance.convert_withList("ABCDEFG", 7) should be("ABCDEFG")
    instance.convert_withList("ABCDEFG", 10) should be("ABCDEFG")
    instance.convert_withList("PAYPALISHIRING", 3) should be("PAHNAPLSIIGYIR")
  }
}
