package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class DecodeWaysTest extends FunSuite with ShouldMatchers {
  val d = new DecodeWays

  test("should work") {
    d.numDecodings("1") should be(1)
    d.numDecodings("12") should be(2)
    d.numDecodings("19") should be(2)
    d.numDecodings("39") should be(1)
    d.numDecodings("231") should be(2)
    d.numDecodings("10") should be(1)
    d.numDecodings("101") should be(1)
    d.numDecodings("1010") should be(1)
    d.numDecodings("110") should be(1)
    d.numDecodings("1110") should be(2)
    d.numDecodings("1310") should be(2)
  }
}
