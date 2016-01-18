package third

import java.util

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WordLadderTest extends FunSuite with ShouldMatchers {
  val w = new WordLadder

  test("should work") {
    val wordList = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    w.ladderLength("hit", "cog", wordList) should be(5)

    val wordList2 = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    w.ladderLength("hit", "hit", wordList2) should be(1)

    val wordList3 = new util.HashSet(util.Arrays.asList("hot","dot","dog","lot","log"))
    w.ladderLength("hit", "hot", wordList3) should be(2)

    val wordList4 = new util.HashSet(util.Arrays.asList("a","b","c"))
    w.ladderLength("a", "c", wordList4) should be(2)

    val wordList5 = new util.HashSet(util.Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"))
    w.ladderLength("red", "tax", wordList5) should be(4)
  }
}
