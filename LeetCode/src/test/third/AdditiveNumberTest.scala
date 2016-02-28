package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class AdditiveNumberTest extends FunSuite with ShouldMatchers {
  val t = new AdditiveNumber

  test("should work") {
    t.isAdditiveNumber("1203") should be(false)
    t.isAdditiveNumber("211738") should be(true)
  }
}
