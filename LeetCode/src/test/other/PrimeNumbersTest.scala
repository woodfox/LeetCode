package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class PrimeNumbersTest extends FunSuite with ShouldMatchers {
  val p = new PrimeNumbers

  test("should work") {
    p.primeByFilter(1).toList should be(List(1))
    p.primeByFilter(2).toList should be(List(1,2))
    p.primeByFilter(5).toList should be(List(1,2,3,5))
    p.primeByFilter(10).toList should be(List(1,2,3,5,7))
    p.primeByFilter(20).toList should be(List(1,2,3,5,7,11,13,17,19))
  }
}
