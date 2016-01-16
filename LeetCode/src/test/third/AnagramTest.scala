package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

class AnagramTest extends FunSuite with ShouldMatchers {
  val t = new Anagram

  test("should find all anagram strings") {
    t.anagrams(Array("abcde", "ab", "ba", "a", "acdeb", "abc")).asScala.toSet should be(Set("ab","ba","abcde","acdeb"))
  }

  test("scala version should find all anagram strings") {
    scalaAnagrams(Array("abcde", "ab", "ba", "a", "acdeb", "abc")).toSet should be(Set("ab","ba","abcde","acdeb"))
  }

  def scalaAnagrams(array: Array[String]) = {
    val grouped = array.groupBy(s => new String(s.toCharArray.sorted))
    val result = grouped.filter(p => p._2.length > 1).map(p => p._2).flatten
    result.toList
  }

}
