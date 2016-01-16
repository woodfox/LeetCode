package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class LetterOfPhoneNumberTest extends FunSuite with ShouldMatchers {
  val l = new LetterOfPhoneNumber

  test("Should generate list of combinations") {
    l.letterCombinations("").asScala.toList should be(List(""))
    l.letterCombinations("2").asScala.toList should be(List("a", "b", "c"))
    l.letterCombinations("23").asScala.toList should be(List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
  }
}
