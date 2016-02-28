package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class TrieTest extends FunSuite with ShouldMatchers {
  val t = new Trie

  test("should work") {
    t.insert("abc")
    t.insert("abd")
    t.insert("abef")
    t.insert("ab")
    t.insert("a")

    t.search("abc") should be(true)
    t.search("ab") should be(true)
    t.search("a") should be(true)
    t.search("abcd") should be(false)
    t.search("abe") should be(false)

    t.startsWith("a") should be(true)
    t.startsWith("ab") should be(true)
    t.startsWith("abc") should be(true)
    t.startsWith("abef") should be(true)
    t.startsWith("abcd") should be(false)
    t.startsWith("abde") should be(false)
  }
}
