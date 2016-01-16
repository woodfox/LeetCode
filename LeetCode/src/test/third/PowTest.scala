package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.math.BigDecimal.RoundingMode

class PowTest extends FunSuite with ShouldMatchers {
  val p = new Pow

  test("should calculate power"){
    round(p.pow(1.23, 0)) should be(BigDecimal(1))
    round(p.pow(1.23, 1)) should be(BigDecimal(1.23))
    round(p.pow(1.1, 2)) should be(BigDecimal(1.21))
    round(p.pow(1.1, 3)) should be(BigDecimal(1.331))
    round(p.pow(1.1, 4)) should be(BigDecimal(1.4641))
    round(p.pow(1.1, 5)) should be(BigDecimal(1.61051))
    round(p.pow(1.1, 6)) should be(BigDecimal(1.771561))
  }

  private def round(d : Double) = BigDecimal(d).setScale(6, RoundingMode.HALF_EVEN)
}
