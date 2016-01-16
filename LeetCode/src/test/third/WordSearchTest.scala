package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class WordSearchTest extends FunSuite with ShouldMatchers {
  val w = new WordSearch

  test("should work") {
    val board = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E'))

    w.exist(board, "ABCCED") should be(true)
    w.exist(board, "SEE") should be(true)
    w.exist(board, "ABCB") should be(false)
    w.exist(board, "ABFCEE") should be(true)
    w.exist(board, "ADEESECBFC") should be(true)
    w.exist(board, "ADEESECCEE") should be(false)
    w.exist(board, "ADEESECBFCFF") should be(false)
  }

  test("should work with limited time") {
    val board = Array(
      Array('A', 'A', 'A', 'A'),
      Array('A', 'A', 'A', 'A'),
      Array('A', 'A', 'A', 'A'),
      Array('A', 'A', 'A', 'A'),
      Array('A', 'A', 'A', 'B'))

    w.exist(board, "AAAAAAAAAAAAAAAAAAAB") should be(true)
    w.exist(board, "AAAAAAAAAAAAAAAAAAAA") should be(false)
  }
}
