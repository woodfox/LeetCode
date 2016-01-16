package third;

import java.util.HashSet;
import java.util.Set;

public class ValidateSudoku {
    int n = 9;

    public boolean isValidSudoku(char[][] board) {
        Set[][] sets = new HashSet[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sets[i][j] = new HashSet<Character>();
                for(char k='1';k<='9';k++) sets[i][j].add(k);
            }
        }

        return validateRows(board, sets) && validateCols(board, sets) && validateBlocks(board, sets);
    }

    private boolean validateRows(char[][] board, Set[][] sets){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                char v = board[row][col];

                for(int i=0;i<n;i++){
                    if(i == col) continue;

                    if(board[row][i] != '.'){
                        if(board[row][i] == v) return false;
                    }else{
                        sets[row][i].remove(v);
                        if(sets[row][i].isEmpty()) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean validateCols(char[][] board, Set[][] sets){
        for(int col=0;col<n;col++){
            for(int row=0;row<n;row++){
                char v = board[row][col];

                for(int i=0;i<n;i++){
                    if(i == row) continue;

                    if(board[i][col] != '.'){
                        if(board[i][col] == v) return false;
                    }else{
                        sets[i][col].remove(v);
                        if(sets[i][col].isEmpty()) return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean validateBlocks(char[][] board, Set[][] sets){
        for(int k=0;k<9;k++){
            int rowStart = (k/3)*3;
            int colStart = (k*3)%9;
            for(int row=rowStart;row<rowStart+3;row++){
                for(int col=colStart;col<colStart+3;col++){
                    char v = board[row][col];

                    for(int i=rowStart;i<rowStart+3;i++){
                        for(int j=colStart;j<colStart+3;j++){
                            if(i==row && j==col) continue;

                            if(board[i][j] != '.'){
                                if(board[i][j] == v) return false;
                            }else{
                                sets[i][j].remove(v);
                                if(sets[i][j].isEmpty()) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
