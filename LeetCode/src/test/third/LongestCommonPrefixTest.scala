package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LongestCommonPrefixTest extends FunSuite with ShouldMatchers {
  val l = new LongestCommonPrefix

  test("should find common prefix") {
    l.longestCommonPrefix(Array("a", "b", "c")) should be("")
    l.longestCommonPrefix(Array("a", "a", "c")) should be("")
    l.longestCommonPrefix(Array("a", "ab", "ac")) should be("a")
    l.longestCommonPrefix(Array("ab", "abc", "abcc")) should be("ab")
    l.longestCommonPrefix(Array("a", "ba", "ac")) should be("")
    l.longestCommonPrefix(Array("aa", "b", "ac")) should be("")
    l.longestCommonPrefix(Array("aa", "ab", "")) should be("")
    l.longestCommonPrefix(Array("abcdefghij", "abcd", "abdc")) should be("ab")
    l.longestCommonPrefix(Array("", "b", "c")) should be("")
    l.longestCommonPrefix(Array("abcde", "abcde", "abcd")) should be("abcd")
  }

  test("should find common prefix in scala way") {
    longestCommonPrefixInScala(Array("abcdefg")) should be("abcdefg")
    longestCommonPrefixInScala(Array("a", "b", "c")) should be("")
    longestCommonPrefixInScala(Array("a", "a", "c")) should be("")
    longestCommonPrefixInScala(Array("a", "ab", "ac")) should be("a")
    longestCommonPrefixInScala(Array("ab", "abc", "abcc")) should be("ab")
    longestCommonPrefixInScala(Array("a", "ba", "ac")) should be("")
    longestCommonPrefixInScala(Array("aa", "b", "ac")) should be("")
    longestCommonPrefixInScala(Array("aa", "ab", "")) should be("")
    longestCommonPrefixInScala(Array("abcdefghij", "abcd", "abdc")) should be("ab")
    longestCommonPrefixInScala(Array("", "b", "c")) should be("")
    longestCommonPrefixInScala(Array("abcde", "abcde", "abcd")) should be("abcd")
  }

  //Try to solve it in Scala way
  def longestCommonPrefixInScala(array: Array[String]): String = {
    if(Option(array).isEmpty || array.length == 0){
      return ""
    }

    val first = array.head
    val others = array.drop(1)
    for(pos <- 0 to first.length-1){
      val pre = first.substring(0, pos+1);
      val flag = others.exists(s => !s.startsWith(pre))
      if(flag){
        return first.substring(0, pos)
      }
    }

    return first
  }
}
