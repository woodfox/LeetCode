package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ScrambleStringTest extends FunSuite with ShouldMatchers {
  val s = new ScrambleString

  test("should work") {
    s.isScramble("s", "t") should be(false)
    s.isScramble("s", "s") should be(true)
    s.isScramble("st", "ts") should be(true)
    s.isScramble("stt", "tst") should be(true)
    s.isScramble("rgtae", "great") should be(true)
    s.isScramble("rgate", "great") should be(true)
    s.isScramble("rtgae", "great") should be(false)
  }

}
