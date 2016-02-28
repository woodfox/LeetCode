package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class PalindromePermutationIITest extends FunSuite  with ShouldMatchers{
  val p = new PalindromePermutationII

  test("should work") {
    p.generatePalindromes("abc").toList should be(List())
    p.generatePalindromes("aab").toSet should be(Set("aba"))
    p.generatePalindromes("aabb").toSet should be(Set("abba","baab"))
    p.generatePalindromes("aabbc").toSet should be(Set("abcba","bacab"))
    p.generatePalindromes("aabbcc").toSet should be(Set("abccba","baccab","bcaacb","acbbca","cabbac","cbaabc"))
  }
}
