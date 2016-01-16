package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SimplifyPathTest extends FunSuite with ShouldMatchers {
  val s = new SimplifyPath

  test("should work"){
    s.simplifyPath("/") should be("/")
    s.simplifyPath("//") should be("/")
    s.simplifyPath("/home//") should be("/home")
    s.simplifyPath("/home/") should be("/home")
    s.simplifyPath("/home/./..") should be("/")
    s.simplifyPath("/a/./../b/./../c/./") should be("/c")
  }
}
