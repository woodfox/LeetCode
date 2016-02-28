package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

class PalindromePartitionTest extends FunSuite with ShouldMatchers with ListHelper {
  val p = new PalindromePartition

  test("should work") {
    convertJavaListToSet(p.partition("a")) should be(Set(List("a")))
    convertJavaListToSet(p.partition("ab")) should be(Set(List("a","b")))
    convertJavaListToSet(p.partition("aba")) should be(Set(List("a","b","a"), List("aba")))
    convertJavaListToSet(p.partition("abac")) should be(Set(List("a","b","a", "c"), List("aba", "c")))

    convertJavaListToSet(p.partition_dp("a")) should be(Set(List("a")))
    convertJavaListToSet(p.partition_dp("ab")) should be(Set(List("a","b")))
    convertJavaListToSet(p.partition_dp("aba")) should be(Set(List("a","b","a"), List("aba")))
    convertJavaListToSet(p.partition_dp("abac")) should be(Set(List("a","b","a", "c"), List("aba", "c")))
  }

}
