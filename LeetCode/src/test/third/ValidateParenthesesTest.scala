package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ValidateParenthesesTest extends FunSuite with ShouldMatchers {
  val v = new ValidateParentheses

  test("should validate string") {
    v.isValid("(") should be(false)
    v.isValid("()") should be(true)
    v.isValid("(()") should be(false)
    v.isValid("({}[])") should be(true)
    v.isValid("()[{}]") should be(true)
    v.isValid("({{{{}}}]") should be(false)
    v.isValid("((({{{[[[]]]}}})))(){}[]") should be(true)
  }
}
