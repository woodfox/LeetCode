package other

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SmallestCharacterTest extends FunSuite with ShouldMatchers {
  val t = new SmallestCharacter

  test("should work"){
    t.search(Array('a','b','d','h','j','k','m','s'), 'b') should be('d')
    t.search(Array('a','b','d','h','j','k','m','s'), 'c') should be('d')
    t.search(Array('a','b','d','h','j','k','m','s'), 'd') should be('h')
    t.search(Array('a','b','d','h','j','k','m','s'), 'g') should be('h')
    t.search(Array('a','b','d','h','j','k','m','s'), 'i') should be('j')
    t.search(Array('a','b','d','h','j','k','m','s'), 'l') should be('m')
    t.search(Array('a','b','d','h','j','k','m','s'), 'n') should be('s')
    t.search(Array('a','b','d','h','j','k','m','s'), 's') should be('s')
    t.search(Array('a','b','d','h','j','k','m','s'), 'z') should be('s')
    t.search(Array('a'), 'z') should be('a')
    t.search(Array('g'), 'f') should be('g')
    t.search(Array('g'), 'h') should be('g')
  }
}
