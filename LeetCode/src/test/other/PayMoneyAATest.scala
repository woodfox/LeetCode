package other

import org.scalatest.FunSuite
import other.PayMoneyAA.Pay
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class PayMoneyAATest extends FunSuite with ShouldMatchers {
  test("should work") {
    val p = new PayMoneyAA
    p.payMoney(Array(5,4,3)).toSet should be(Set(new Pay(2,0,1)))
    p.payMoney(Array(5,1,3)).toSet should be(Set(new Pay(1,0,2)))
    p.payMoney(Array(1,5,2,2)).toSet should be(Set(new Pay(0,1,1.5), new Pay(2,1,0.5), new Pay(3,1,0.5)))
    p.payMoney(Array(1,5,4)).toSet should be(Set(new Pay(0,1,1.6666666666666666), new Pay(0,2,0.66666666666666)))
  }
}
