package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class IsmorphicStringTest extends FunSuite with ShouldMatchers {
  val i = new IsmorphicString

  test("should work") {
    i.isIsomorphic(null, "") should be(false)
    i.isIsomorphic("", "a") should be(false)
    i.isIsomorphic("a", "a") should be(true)
    i.isIsomorphic("", "") should be(true)
    i.isIsomorphic("add", "egg") should be(true)
    i.isIsomorphic("adda", "egge") should be(true)
    i.isIsomorphic("adda", "eggo") should be(false)
    i.isIsomorphic("ad", "aa") should be(false)
  }
}
