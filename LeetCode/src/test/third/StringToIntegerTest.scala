package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class StringToIntegerTest extends FunSuite with ShouldMatchers {
  val instance = new StringToInteger

  test("should convert string to integer"){
    instance.atoi("") should be(0)
    instance.atoi("   ") should be(0)
    instance.atoi("  ab ") should be(0)
    instance.atoi(" +1 ") should be(1)
    instance.atoi(" -12 ") should be(-12)
    instance.atoi(" -12.345") should be(-12)
    instance.atoi("+12.345") should be(12)
    instance.atoi("12 345") should be(12)
    instance.atoi(" 12345+") should be(12345)
    instance.atoi("  12-345  ") should be(12)
    instance.atoi("-.3456e9") should be(0)
    instance.atoi("+-12345") should be(0)
    instance.atoi("9223372036854775809") should be(Integer.MAX_VALUE)
  }
}
