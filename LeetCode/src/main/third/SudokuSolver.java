package third;

public class SudokuSolver {
    int n = 9;

    public void solveSudoku(char[][] board) {
        backtrace(board, 0);
    }

    private boolean backtrace(char[][] board, int pos) {
        if(pos >= n*n) return true;

        int row = pos/n;
        int col = pos%n;
        if(board[row][col] != '.'){
            return backtrace(board, pos+1);
        }else {
            for(char c = '1';c<='9';c++){
                board[row][col] = c;
                if(validateRows(board, pos) && validateCols(board, pos) && validateBlocks(board, pos) && backtrace(board, pos+1)){
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean validateRows(char[][] board, int pos){
        int row = pos/n;
        int col = pos%n;

        char v = board[row][col];

        for(int i=0;i<n;i++){
            if(i == col) continue;

            if(board[row][i] != '.'){
                if(board[row][i] == v) return false;
            }
        }

        return true;
    }

    private boolean validateCols(char[][] board, int pos){
        int row = pos/n;
        int col = pos%n;

        char v = board[row][col];

        for(int i=0;i<n;i++){
            if(i == row) continue;

            if(board[i][col] != '.'){
                if(board[i][col] == v) return false;
            }
        }

        return true;
    }

    private boolean validateBlocks(char[][] board, int pos){
        int row = pos/n;
        int col = pos%n;
        char v = board[row][col];
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;

        for(int i=rowStart;i<rowStart+3;i++){
            for(int j=colStart;j<colStart+3;j++){
                if(i==row && j==col) continue;

                if(board[i][j] != '.'){
                    if(board[i][j] == v) return false;
                }
            }
        }

        return true;
    }
}
