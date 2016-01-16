package third;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[][] count = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count[i][j] = 0;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(backtrace(i, j, board, word, count, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrace(int row, int col, char[][] board, String word, int[][] count, int pos) {
        int m = board.length;
        int n = board[0].length;

        if(pos >= word.length()){
            return true;
        }else if(row >= m || row < 0 || col >= n || col < 0 || count[row][col] > 0 || board[row][col] != word.charAt(pos)){
            return false;
        }else{
            count[row][col]++;
            if(backtrace(row+1, col, board, word, count, pos+1)) return true;
            if(backtrace(row-1, col, board, word, count, pos+1)) return true;
            if(backtrace(row, col+1, board, word, count, pos+1)) return true;
            if(backtrace(row, col-1, board, word, count, pos+1)) return true;
            count[row][col]--;
        }

        return false;
    }
}
