package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class StrobogrammaticNumberIITest extends FunSuite with ShouldMatchers {
  val s = new StrobogrammaticNumberII

  test("should work") {
    s.findStrobogrammatic(0).toSet should be(Set())
    s.findStrobogrammatic(1).toSet should be(Set("1","0","8","6","9"))
    s.findStrobogrammatic(2).toSet should be(Set("11","88","69","96"))
    s.findStrobogrammatic(3).toSet should be(Set("101","181","111","818","808","888","619","609","689","916","906","986"))
  }
}
