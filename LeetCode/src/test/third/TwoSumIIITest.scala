package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class TwoSumIIITest extends FunSuite with ShouldMatchers {

  test("should work") {
    val t = new TwoSumIII
    t.add(1)
    t.find(3) should be(false)

    t.add(2)
    t.find(3) should be(true)

    t.find(5) should be(false)
    t.add(4)
    t.find(5) should be(true)
    t.find(6) should be(true)
    t.find(7) should be(false)
  }

  test("anothe way should work") {
    val t = new TwoSumIII_another
    t.add(1)
    t.find(3) should be(false)

    t.add(2)
    t.find(3) should be(true)

    t.find(5) should be(false)
    t.add(4)
    t.find(5) should be(true)
    t.find(6) should be(true)
    t.find(7) should be(false)
  }
}
