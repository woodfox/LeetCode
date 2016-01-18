package third

import java.util

import _root_.util.ListHelper
import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WordLadderIITest extends FunSuite with ShouldMatchers with ListHelper {
  val w = new WordLadderII

  test("should work") {
    val wordList = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    convertJavaListToSet(w.findLadders("hit", "cog", wordList)) should be(
      Set(List("hit", "hot", "dot", "dog", "cog"),
          List("hit", "hot", "lot", "log", "cog")))

    val wordList2 = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    convertJavaListToSet(w.findLadders("hit", "hit", wordList2)) should be(
      Set(List("hit")))

    val wordList3 = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    convertJavaListToSet(w.findLadders("hit", "hot", wordList3)) should be(
      Set(List("hit", "hot")))

    val wordList4 = new util.HashSet(util.Arrays.asList("a","b","c"))
    convertJavaListToSet(w.findLadders("a", "c", wordList4)) should be(
      Set(List("a", "c")))

    val wordList5 = new util.HashSet(util.Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"))
    convertJavaListToSet(w.findLadders("red", "tax", wordList5)) should be(
      Set(List("red", "rex", "tex", "tax"),
          List("red", "ted", "tex", "tax"),
          List("red", "ted", "tad", "tax")))
  }
}
