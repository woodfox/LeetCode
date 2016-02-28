package third

import org.scalatest.FunSuite
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class FlipGameTest extends FunSuite with ShouldMatchers {
  val t = new FlipGame

  test("should work") {
    t.flip("++").toSet should be(Set("--"))
    t.flip("+++").toSet should be(Set("+--","--+"))
    t.flip("++++").toSet should be(Set("+--+","--++","++--"))
    t.flip("+++++").toSet should be(Set("+--++","--+++","++--+","+++--"))
  }
}
