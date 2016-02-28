package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class GasStationTest extends FunSuite with ShouldMatchers {
  val g = new GasStation

  test("should work") {
    g.canCompleteCircuit(Array(11), Array(9)) should be(0)
    g.canCompleteCircuit(Array(2), Array(2)) should be(0)
    g.canCompleteCircuit(Array(8), Array(9)) should be(-1)
    g.canCompleteCircuit(Array(8,7), Array(9,6)) should be(1)
    g.canCompleteCircuit(Array(11,5,7,8), Array(9,8,5,9)) should be(2)
    g.canCompleteCircuit(Array(10,5,7,8), Array(9,8,5,9)) should be(-1)
  }

}
