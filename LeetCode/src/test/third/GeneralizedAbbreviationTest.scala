package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class GeneralizedAbbreviationTest extends FunSuite with ShouldMatchers{
  val t = new GeneralizedAbbreviation
  test("should work") {
    t.generateAbbreviations("").toSet should be(Set())
    t.generateAbbreviations("w").toSet should be(Set("w","1"))
    t.generateAbbreviations("wo").toSet should be(Set("wo","w1","1o","2"))
    t.generateAbbreviations("wor").toSet should be(Set("wor","1or","w1r","wo1","1o1","2r","w2","3"))
    t.generateAbbreviations("word").toSet should be(Set("word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"))
  }
}
