package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestValidParenthesesTest extends FunSuite with ShouldMatchers {
  val l = new LongestValidParentheses

  test("should find max length of valid parentheses"){
    l.longestValidParentheses("") should be(0)
    l.longestValidParentheses("(") should be(0)
    l.longestValidParentheses(")") should be(0)
    l.longestValidParentheses("()") should be(2)
    l.longestValidParentheses("()()(") should be(4)
    l.longestValidParentheses("(())())") should be(6)
    l.longestValidParentheses("((()())") should be(6)
    l.longestValidParentheses("(()()())())))") should be(10)
    l.longestValidParentheses(")()())") should be(4)
    l.longestValidParentheses("(((((((((") should be(0)
  }
}
