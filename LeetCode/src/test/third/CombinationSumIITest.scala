package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

import scala.collection.mutable.ListBuffer

class CombinationSumIITest extends FunSuite with ShouldMatchers with ListHelper {
  val c = new CombinationSumII

  test("should find the sets"){
    convertJavaListToSet(c.combinationSum2(Array(8,7,4,3), 7)).toSet should be(Set(List(3,4), List(7)))
    convertJavaListToSet(c.combinationSum2(Array(2,3,6,7), 7)).toSet should be(Set(List(7)))
    convertJavaListToSet(c.combinationSum2(Array(2,3,6,7), 9)).toSet should be(Set(List(2,7), List(3,6)))
    convertJavaListToSet(c.combinationSum2(Array(2,3,6,7), 1)).toSet should be(Set())
    convertJavaListToSet(c.combinationSum2(Array(2,3,6,7), 6)).toSet should be(Set(List(6)))
    convertJavaListToSet(c.combinationSum2(Array(2,3,6,7), 2)).toSet should be(Set(List(2)))
    convertJavaListToSet(c.combinationSum2(Array(10,1,2,7,6,1,5), 8)).toSet should be(Set(List(1,7),List(1,2,5),List(2,6),List(1,1,6)))
    convertJavaListToSet(c.combinationSum2(Array(1,1), 1)).toSet should be(Set(List(1)))
  }

  test("scala versionshould find all sets"){
    scalaCombinationSum(Array(2,3,6,7), 7).toSet should be(Set(List(2,2,3), List(7)))
    scalaCombinationSum(Array(2,3,6,7), 9).toSet should be(Set(List(2,7), List(3,6), List(3, 3, 3), List(2,2,2,3)))
    scalaCombinationSum(Array(2,3,6,7), 1).toSet should be(Set())
    scalaCombinationSum(Array(2,3,6,7), 6).toSet should be(Set(List(2,2,2), List(3,3), List(6)))
    scalaCombinationSum(Array(2,3,6,7), 2).toSet should be(Set(List(2)))
    scalaCombinationSum(Array(10,1,2,7,6,1,5), 8).toSet should be(Set(List(1,7),List(1,2,5),List(2,6),List(1,1,6)))
    scalaCombinationSum(Array(1,1), 1).toSet should be(Set(List(1)))
  }

  def scalaCombinationSum(c: Array[Int], target: Int): List[List[Int]] = {
    val result = ListBuffer[List[Int]]()
    backtrack(c, 0, target, Nil, result)

    result.toSet.toList
  }

  def backtrack(c: Array[Int], pos: Int, target: Int, sub: List[Int], result: ListBuffer[List[Int]]):Unit = {
    if(pos < c.length){
      for(i <- pos to c.length-1){
        val sum = sub.sum
        if(sum + c(i) == target){
          result += (sub :+ c(i))
        }else if(sum + c(i) < target){
          backtrack(c, i, target, (sub :+ c(i)), result)
        }
      }
    }
  }
}
