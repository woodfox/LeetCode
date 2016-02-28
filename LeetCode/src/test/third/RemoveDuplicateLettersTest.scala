package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class RemoveDuplicateLettersTest extends FunSuite with ShouldMatchers {
  val t = new RemoveDuplicateLetters

  test("should work") {
    t.removeDuplicateLetters("bcabc") should be("abc")
    t.removeDuplicateLetters("baab") should be("ab")
    t.removeDuplicateLetters("bcacb") should be("acb")
    t.removeDuplicateLetters("dcbacdcd") should be("bacd")
    t.removeDuplicateLetters("dcba") should be("dcba")
    t.removeDuplicateLetters("abcd") should be("abcd")
    t.removeDuplicateLetters("caccabad") should be("acbd")
  }
}
