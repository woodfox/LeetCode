package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class AddOperatorsTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val t = new AddOperators
    t.addOperators("123",6).toSet should be(Set("1+2+3","1*2*3"))
    t.addOperators("123",7).toSet should be(Set("1+2*3"))
    t.addOperators("123",5).toSet should be(Set("1*2+3"))
    t.addOperators("123",9).toSet should be(Set("12-3"))
    t.addOperators("123",15).toSet should be(Set("12+3"))
    t.addOperators("232",8).toSet should be(Set("2*3+2","2+3*2"))
    t.addOperators("105",5).toSet should be(Set("1*0+5","10-5"))
    t.addOperators("00",0).toSet should be(Set("0*0","0+0","0-0"))
    t.addOperators("3456237490",9191).toSet should be(Set())
  }
}
