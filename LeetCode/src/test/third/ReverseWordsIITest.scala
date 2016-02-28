package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ReverseWordsIITest extends FunSuite with ShouldMatchers {
  val r = new ReverseWordsII

  test("should work") {
    r.reverse("") should be("")
    r.reverse("a") should be("a")
    r.reverse("abc") should be("abc")
    r.reverse("abc def gh") should be("gh def abc")
    r.reverse("abcdef gh") should be("gh abcdef")
    r.reverse("abcdefgh") should be("abcdefgh")
  }

  test("simple version should work") {
    r.reverse_simple("") should be("")
    r.reverse_simple("a") should be("a")
    r.reverse_simple("abc") should be("abc")
    r.reverse_simple("abc def gh") should be("gh def abc")
    r.reverse_simple("abcdef gh") should be("gh abcdef")
    r.reverse_simple("abcdefgh") should be("abcdefgh")
  }
}
