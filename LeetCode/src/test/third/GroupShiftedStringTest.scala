package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper
import scala.collection.JavaConversions._

class GroupShiftedStringTest extends FunSuite with ShouldMatchers with ListHelper {
  val g = new GroupShiftedString

  test("should work") {
    convertJavaListToSet(g.groupStrings(List("abc", "bcd"))) should be(Set(List("abc","bcd")))
    convertJavaListToSet(g.groupStrings(List("a", "b","c","x","z"))) should be(Set(List("a","b","c","x","z")))
    convertJavaListToSet(g.groupStrings(List("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"))) should
      be(Set(List("abc","bcd","xyz"), List("acef"), List("az","ba"),List("a","z")))
  }

  test("slow version should work") {
    convertJavaListToSet(g.groupStrings_slow(List("abc", "bcd"))) should be(Set(List("abc","bcd")))
    convertJavaListToSet(g.groupStrings_slow(List("a", "b","c","x","z"))) should be(Set(List("a","b","c","x","z")))
    convertJavaListToSet(g.groupStrings_slow(List("abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"))) should
      be(Set(List("abc","bcd","xyz"), List("acef"), List("az","ba"),List("a","z")))
  }
}
