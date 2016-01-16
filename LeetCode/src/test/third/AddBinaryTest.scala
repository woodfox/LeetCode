package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class AddBinaryTest extends FunSuite with ShouldMatchers {
  val t = new AddBinary

  test("should return added binary"){
    t.addBinary("", "0") should be("0")
    t.addBinary("1", "0") should be("1")
    t.addBinary("1", "1") should be("10")
    t.addBinary("11", "1") should be("100")
    t.addBinary("11", "0") should be("11")
    t.addBinary("11", "10") should be("101")
    t.addBinary("11", "101") should be("1000")
  }
}
