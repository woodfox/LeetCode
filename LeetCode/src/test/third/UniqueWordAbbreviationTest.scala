package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class UniqueWordAbbreviationTest extends FunSuite with ShouldMatchers {
  val t = new UniqueWordAbbreviation(List("deer", "door", "cake", "card"))

  test("should work") {
    t.isUnique("dear") should be(false)
    t.isUnique("cane") should be(false)
    t.isUnique("cart") should be(true)
    t.isUnique("make") should be(true)
  }
}
