package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

import scala.collection.JavaConversions._

class WordBreakIITest extends FunSuite with ShouldMatchers {
  val w = new WordBreakII

  test("should work") {
    w.wordBreak("leetcode", Set("leet", "code")).toSet should be(Set("leet code"))
    w.wordBreak("leetcode", Set("leet", "code", "leetcode")).toSet should be(Set("leet code", "leetcode"))
    w.wordBreak("leetcode", Set("leet", "code", "leetcode", "code")).toSet should be(Set("leet code", "leetcode"))
    w.wordBreak("leetcode", Set("leet", "code", "cod", "e")).toSet should be(Set("leet code", "leet cod e"))
    w.wordBreak("leetcode", Set("leet", "cod")).toSet should be(Set())
    w.wordBreak("leetcode", Set[String]()).toSet should be(Set())
    w.wordBreak("", Set[String]()).toSet should be(Set())
  }

}
