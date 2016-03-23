package other

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class ConvertReversePolishNotationTest extends FunSuite with ShouldMatchers{
  val t = new ConvertReversePolishNotation

  test("should work") {
    t.convertToRPN(Array("(","(","(","(","(",")",")",")",")",")")).toList should be(List())
  }
}
