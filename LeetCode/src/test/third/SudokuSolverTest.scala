package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SudokuSolverTest extends FunSuite with ShouldMatchers {
  val v = new SudokuSolver

  test("should return true for valid sudoku"){
    val board = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','.'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )

    v.solveSudoku(board)

    board should be(Array("534678912", "672195348", "198342567", "859761423", "426853791", "713924856", "961537284", "287419635", "345286179").map(_.toCharArray))
  }
}
