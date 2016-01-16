package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class NQueueTest extends FunSuite with ShouldMatchers {
  val n = new NQueue

  test("Should generate all solutions for n-queue") {
    convert(n.solveNQueens(2).asScala.toSet) should be(Set())
    convert(n.solveNQueens(3).asScala.toSet) should be(Set())
    convert(n.solveNQueens(4).asScala.toSet) should be(Set(
      List(".Q..", "...Q", "Q...", "..Q."),
      List("..Q.", "Q...", "...Q", ".Q..")
    ))
  }

  def convert(result: Set[Array[String]]) = {
    result.map(_.toList)
  }
}
