package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ExpressionEvaluationTest extends FunSuite with ShouldMatchers {
  val t = new ExpressionEvaluation

  test("should work"){
    t.evaluateExpression(List("1","+","2")) should be(3)
    t.evaluateExpression(List("1")) should be(1)
    t.evaluateExpression(List("1","+","2","*","3")) should be(7)
    t.evaluateExpression(List("1","+","(","2","*","6","/","3",")","-","9")) should be(-4)
    t.evaluateExpression(List("1","+","(","2","*","(","6","/","3",")",")","-","9")) should be(-4)
    t.evaluateExpression(List("(","1","+","2",")","*","(","6","/","3",")","-","9")) should be(-3)
    t.evaluateExpression(List("(","1","+","2",")","*","(","(","6","/","3",")","-","9",")")) should be(-21)
  }
}
