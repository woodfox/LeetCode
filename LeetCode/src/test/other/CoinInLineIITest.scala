package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class CoinInLineIITest extends FunSuite with ShouldMatchers {
  val t = new CoinInLineII

  test("should work") {
    t.firstWillWin(Array(16,27,25,23,25,16,12,9,1,2,7,20,19,23,16,0,6,22,16,11,8,27,9,2,20,2,13,7,25,29,12,12,18,29,27,
      13,16,1,22,9,3,21,29,14,7,8,14,5,0,23,16,1,20)) should be(true)

    t.firstWillWin(Array(100,200,400,300,400,800,500,600,1200)) should be(false)
  }
}
