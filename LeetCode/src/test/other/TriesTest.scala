package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class TriesTest extends FunSuite with ShouldMatchers {
  val t = new Tries

  test("should work") {
    t.add("")
    t.add("a")
    t.add("b")
    t.add("abc")
    t.add("adef")
    t.add("adhijk")
    t.add("abefjk")

    t.contains("") should be(true)
    t.contains("a") should be(true)
    t.contains("b") should be(true)
    t.contains("abc") should be(true)
    t.contains("adef") should be(true)
    t.contains("abefjk") should be(true)

    t.contains("ab") should be(false)
    t.contains("abcd") should be(false)
    t.contains("ade") should be(false)
    t.contains("adeg") should be(false)
    t.contains("adefj") should be(false)
  }
}
