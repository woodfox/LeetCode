package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class WordBreakTest extends FunSuite with ShouldMatchers {
  val w = new WordBreak

  test("should work") {
    w.wordBreak("leetcode", Set[String]()) should be(false)
    w.wordBreak("leetcode", Set[String]()) should be(false)
    w.wordBreak("leetcode", Set("leet", "cod")) should be(false)
    w.wordBreak("leetcode", Set("leet", "code")) should be(true)
    w.wordBreak("leetcode", Set("leet", "code", "aaa")) should be(true)
    w.wordBreak("leetcode", Set("leetcode", "aaa")) should be(true)
    w.wordBreak("leetcode", Set("leetcodeaaa")) should be(false)
  }

}
