package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WordPatternIITest extends FunSuite with ShouldMatchers{
  val t = new WordPatternII

  test("shold work") {
    t.isValid("abab", "redblueredblue") should be(true)
    t.isValid("aaaa", "redblueredblue") should be(false)
    t.isValid("aaaa", "asdasdasdasd") should be(true)
    t.isValid("aabb", "xyzabcxzyabc") should be(false)
    t.isValid("abab", "xyzabcxzyabc") should be(false)
    t.isValid("abab", "xyzabcxyzabc") should be(true)
    t.isValid("abcd", "xyzabcxzyabc") should be(true)
  }
}
