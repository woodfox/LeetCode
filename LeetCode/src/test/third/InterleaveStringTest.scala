package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class InterleaveStringTest extends FunSuite with ShouldMatchers {
  val i = new InterleaveString

  test("should work") {
    i.isInterleave("", "", "") should be(true)
    i.isInterleave("a", "", "a") should be(true)
    i.isInterleave("a", "b", "ab") should be(true)
    i.isInterleave("a", "b", "ba") should be(true)
    i.isInterleave("a", "b", "bac") should be(false)
    i.isInterleave("a", "", "") should be(false)
    i.isInterleave("ac", "cb", "accb") should be(true)
    i.isInterleave("ac", "cb", "acbc") should be(true)
    i.isInterleave("ac", "cb", "abcc") should be(false)
  }
}
