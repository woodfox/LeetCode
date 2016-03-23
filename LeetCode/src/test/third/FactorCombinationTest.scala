package third

import org.scalatest.FunSuite
import util.ListHelper
import scala.collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers

class FactorCombinationTest extends FunSuite with ShouldMatchers with ListHelper {
  val t = new FactorCombination

  test("simple version should work") {
    t.combineFactors_simple(1).toSet should be(Set())
    t.combineFactors_simple(3).toSet should be(Set())
    convertJavaListToSet(t.combineFactors_simple(4)) should be(Set(List(2,2)))
    convertJavaListToSet(t.combineFactors_simple(5)) should be(Set())
    convertJavaListToSet(t.combineFactors_simple(6)) should be(Set(List(2,3)))
    convertJavaListToSet(t.combineFactors_simple(7)) should be(Set())
    convertJavaListToSet(t.combineFactors_simple(8)) should be(Set(List(2,4),List(2,2,2)))
    convertJavaListToSet(t.combineFactors_simple(9)) should be(Set(List(3,3)))
    convertJavaListToSet(t.combineFactors_simple(10)) should be(Set(List(2,5)))
    convertJavaListToSet(t.combineFactors_simple(12)) should be(Set(List(2,6),List(2,2,3),List(3,4),List(3,2,2)))
    convertJavaListToSet(t.combineFactors_simple(15)) should be(Set(List(3,5)))
    convertJavaListToSet(t.combineFactors_simple(16)) should be(Set(List(2,8),List(2,2,4),List(2,2,2,2),List(4,4),List(4,2,2)))
    convertJavaListToSet(t.combineFactors_simple(20)) should be(Set(List(2,10),List(2,2,5),List(4,5)))
    convertJavaListToSet(t.combineFactors_simple(28)) should be(Set(List(2,14),List(2,2,7),List(4,7)))
  }
}
