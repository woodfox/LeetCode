package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class DifferenctWaysToCalculateTest extends FunSuite with ShouldMatchers {

  test("should work") {
    val d = new DifferenctWaysToCalculate

    d.diffWaysToCompute("0+1").toList should be(List(1))
  }
}
