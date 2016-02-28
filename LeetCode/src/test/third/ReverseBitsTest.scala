package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ReverseBitsTest extends FunSuite with ShouldMatchers {
  val r = new ReverseBits

  test("should work") {
    r.reverseBits(1) should be(Integer.MIN_VALUE)
    r.reverseBits(2) should be((1<<30))
    r.reverseBits(43261596) should be(964176192)
    r.reverseBits(Integer.MIN_VALUE) should be(1)

  }

  test("enhanced version should work") {
    r.reverseBits_fast(1) should be(Integer.MIN_VALUE)
    r.reverseBits_fast(2) should be((1<<30))
    r.reverseBits_fast(43261596) should be(964176192)
    r.reverseBits_fast(Integer.MIN_VALUE) should be(1)

  }
}
