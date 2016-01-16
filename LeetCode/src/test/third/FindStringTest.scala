package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class FindStringTest extends FunSuite with ShouldMatchers {
  val f = new FindString

  test("should find the index of matched string") {
    f.strStr("ababcababc", "ab") should be(0)
    f.strStr("ababcababc", "abc") should be(2)
    f.strStr("ababcababd", "abd") should be(7)
    f.strStr("ababcababc", "cab") should be(4)
    f.strStr("ababcababc", "abd") should be(-1)
    f.strStr("ababcababc", "ababcababc") should be(0)
    f.strStr("abababacd", "ababacd") should be(2)
    f.strStr("abababac", "ababacd") should be(-1)
  }

}
