package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class RemoveInvalidParenthesesTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val t = new RemoveInvalidParentheses

    t.removeInvalidParentheses("").toSet should be(Set(""))
    t.removeInvalidParentheses(")(").toSet should be(Set(""))
    t.removeInvalidParentheses("()").toSet should be(Set("()"))
    t.removeInvalidParentheses("(()").toSet should be(Set("()"))
    t.removeInvalidParentheses("()())()").toSet should be(Set("()()()", "(())()"))
    t.removeInvalidParentheses("(a)())()").toSet should be(Set("(a)()()", "(a())()"))
    t.removeInvalidParentheses("((()))((()(()").toSet should be(Set("((()))()()", "((()))(())"))
    t.removeInvalidParentheses(")(()(()))(a(e()").toSet should be(Set("(()(()))(ae)","(()(()))a(e)", "(()(()))ae()"))
  }
}
