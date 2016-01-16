package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class GenerateParenthesesTest extends FunSuite with ShouldMatchers{
  val g = new GenerateParentheses

  test("Should go through all combinations") {
    g.generateParenthesis(1).asScala.toSet should be(Set("()"))
    g.generateParenthesis(2).asScala.toSet should be(Set("()()", "(())"))
    g.generateParenthesis(3).asScala.toSet should be(Set("(()())", "((()))", "()(())", "()()()", "(())()"))
    g.generateParenthesis(4).asScala.toSet should be(
      Set("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())",
     "(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"))
  }
}
