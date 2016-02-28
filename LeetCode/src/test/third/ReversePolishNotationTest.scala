package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ReversePolishNotationTest extends FunSuite with ShouldMatchers {
  val r =  new ReversePolishNotation

  test("should work") {
    r.evalRPN(Array("2","1","+")) should be(3)
    r.evalRPN(Array("2","1","+","3","-")) should be(0)
    r.evalRPN(Array("6","2","1","+","1","-","/")) should be(3)
  }
}
