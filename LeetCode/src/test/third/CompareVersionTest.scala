package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CompareVersionTest extends FunSuite with ShouldMatchers {
  val c = new CompareVersion

  test("should work") {
    c.compareVersion("1","2") should be(-1)
    c.compareVersion("2","2") should be(0)
    c.compareVersion("3","2") should be(1)
    c.compareVersion("1.0","1.0") should be(0)
    c.compareVersion("1.1","1.0") should be(1)
    c.compareVersion("1.1","1.21") should be(-1)
    c.compareVersion("1.2","1.21") should be(-1)
    c.compareVersion("1.20","1.21") should be(-1)
    c.compareVersion("1.20","1.2") should be(1)
    c.compareVersion("1.2","1.20") should be(-1)
    c.compareVersion("1.","1.20") should be(-1)
    c.compareVersion("1.","1.0") should be(0)
    c.compareVersion("1.1","1.") should be(1)
    c.compareVersion("1.11","2.0") should be(-1)
    c.compareVersion("1.11","3.11") should be(-1)
    c.compareVersion("1.11","1.11") should be(0)
    c.compareVersion("1.1.1","1") should be(1)
    c.compareVersion("1","1.1.1") should be(-1)
    c.compareVersion("1.1.1.0","1.1.1") should be(0)
    c.compareVersion("1.1.1.0","1.1.2") should be(-1)
    c.compareVersion("1.1.1.1","1.1.2") should be(-1)
    c.compareVersion("1.1.2.1","1.1.2") should be(1)
    c.compareVersion("1.1.2.1","1") should be(1)
    c.compareVersion("1.1.2.1","2") should be(-1)
    c.compareVersion("1.1.2.1","2.1.1") should be(-1)
    c.compareVersion("1.1.2.1","0") should be(1)
    c.compareVersion("1.1.2.1","1.") should be(1)

  }
}
