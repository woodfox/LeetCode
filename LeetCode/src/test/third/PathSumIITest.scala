package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.{ListHelper, TreeHelper}

class PathSumIITest extends FunSuite with ShouldMatchers with TreeHelper with ListHelper {
  val p = new PathSumII

  test("Should work") {
    convertJavaListToSet(p.pathSum(createTree(List()), 1)) should be(Set())
    convertJavaListToSet(p.pathSum(createTree(List(1)), 1)) should be(Set(List(1)))
    convertJavaListToSet(p.pathSum(createTree(List(1,2)), 1)) should be(Set())
    convertJavaListToSet(p.pathSum(createTree(List(1,2)), 3)) should be(Set(List(1,2)))
    convertJavaListToSet(p.pathSum(createTree(List(1,2,3)), 3)) should be(Set(List(1,2)))
    convertJavaListToSet(p.pathSum(createTree(List(1,2,3)), 4)) should be(Set(List(1,3)))
    convertJavaListToSet(p.pathSum(createTree(List(1,2,3,1)), 4)) should be(Set(List(1,2,1), List(1,3)))
    convertJavaListToSet(p.pathSum(createTree(List(1,2,3,4,5,1)), 8)) should be(Set(List(1,2,4,1), List(1,2,5)))
  }
}
