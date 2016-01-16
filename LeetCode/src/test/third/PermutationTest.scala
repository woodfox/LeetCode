package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import util.ListHelper

import scala.collection.mutable.ListBuffer

class PermutationTest extends FunSuite with ListHelper with ShouldMatchers {
  val p = new Permutation

  test("should return all permutation") {
    convertJavaListToSet(p.permute(Array(1))).toSet should be(Set(List(1)))
    convertJavaListToSet(p.permute(Array(1, 2))).toSet should be(Set(List(1, 2), List(2, 1)))
    convertJavaListToSet(p.permute(Array(2, 1))).toSet should be(Set(List(1, 2), List(2, 1)))
    convertJavaListToSet(p.permute(Array(2, 1, 2))).toSet should be(Set(List(1, 2, 2), List(2, 1, 2), List(2, 2, 1)))
    convertJavaListToSet(p.permute(Array(2, 1, 3))).toSet should be(Set(List(1, 2, 3), List(1, 3, 2), List(2,1,3), List(2,3,1), List(3,1,2), List(3,2,1)))
  }

  test("scalaJump should return all permutation") {
    scalaPermutate(Array(1)).toSet should be(Set(List(1)))
    scalaPermutate(Array(1, 2)).toSet should be(Set(List(1, 2), List(2, 1)))
    scalaPermutate(Array(2, 1)).toSet should be(Set(List(1, 2), List(2, 1)))
    scalaPermutate(Array(2, 1, 2)).toSet should be(Set(List(1, 2, 2), List(2, 1, 2), List(2, 2, 1)))
    scalaPermutate(Array(2, 1, 3)).toSet should be(Set(List(1, 2, 3), List(1, 3, 2), List(2,1,3), List(2,3,1), List(3,1,2), List(3,2,1)))
  }

  def scalaPermutate(a: Array[Int]) = {
    val result = ListBuffer[List[Int]]()
    val map = a.groupBy(v => v)
      .map{ case (v, list) =>
        (v -> list.length)
    }.toMap

    backtrack(map, a.length, Nil, result)
    result.toList
  }

  def backtrack(map: Map[Int, Int], n: Int, sub: List[Int], result: ListBuffer[List[Int]]) {
    if(sub.length == n) {
      result += sub
    }else{
      for(a <- map.keys) {
        val count = map(a)
        if(count > 0){
          val updatedMap = map + (a -> (count - 1))
          backtrack(updatedMap, n, sub :+ a, result)
        }
      }
    }
  }
}
