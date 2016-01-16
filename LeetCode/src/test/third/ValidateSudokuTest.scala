package third

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class ValidateSudokuTest extends FunSuite with ShouldMatchers {
  val v = new ValidateSudoku

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

    v.isValidSudoku(board) should be(true)
  }

  test("should return false for invalid row sudoku"){
    val board = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','9'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','2','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )

    v.isValidSudoku(board) should be(false)
  }

  test("should return false for invalid column sudoku"){
    val board = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','9'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','.','7','9')
    )

    v.isValidSudoku(board) should be(false)
  }

  test("should return false for invalid block sudoku"){
    val board = Array(
      Array('5','3','.','.','7','.','.','.','.'),
      Array('6','.','.','1','9','5','.','.','9'),
      Array('.','9','8','.','.','.','.','6','.'),
      Array('8','.','.','.','6','.','.','.','3'),
      Array('4','.','.','8','.','3','.','.','1'),
      Array('7','.','.','.','2','.','.','.','6'),
      Array('.','6','.','.','.','.','2','8','.'),
      Array('.','.','.','4','1','9','.','.','5'),
      Array('.','.','.','.','8','.','5','7','9')
    )

    v.isValidSudoku(board) should be(false)
  }

  test("should return false for invalid sudoku"){
    val board = Array(
      Array('.','.','4','.','.','.','6','3','.'),
      Array('.','.','.','.','.','.','.','.','.'),
      Array('5','.','.','.','.','.','.','9','.'),
      Array('.','.','.','5','6','.','.','.','.'),
      Array('4','.','3','.','.','.','.','.','1'),
      Array('.','.','.','7','.','.','.','.','.'),
      Array('.','.','.','5','.','.','.','.','.'),
      Array('.','.','.','.','.','.','.','.','.'),
      Array('.','.','.','.','.','.','.','.','.')
    )

    v.isValidSudoku(board) should be(false)
  }
}
