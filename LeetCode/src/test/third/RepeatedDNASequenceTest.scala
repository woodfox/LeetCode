package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConversions._

class RepeatedDNASequenceTest extends FunSuite with ShouldMatchers {
  test("should work") {
    val r = new RepeatedDNASequence

    r.findRepeatedDnaSequences("abc").toList should be(List())
    r.findRepeatedDnaSequences("AAAAAAAAAAA").toList should be(List("AAAAAAAAAA"))
    r.findRepeatedDnaSequences("AAAAAAAAAAAAAAAAAA").toList should be(List("AAAAAAAAAA"))
    r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCC").toList should be(List())
    r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCC").toList should be(List("AAAAACCCCC"))
    r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAA").toList should be(List("AAAAACCCCC","CCCCCAAAAA"))
    r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toList should be(List("AAAAACCCCC","CCCCCAAAAA"))
    r.findRepeatedDnaSequences("RSTXYZABCDEFGHIJABCDEFGHIJKLMNOPQ").toList should be(List("ABCDEFGHIJ"))
  }
}
