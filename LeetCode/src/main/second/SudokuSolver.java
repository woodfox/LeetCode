package second;

public class SudokuSolver {
    public void solveSudoku(char[][] a) {
        int n = 9;
        boolean[][] f = new boolean[n][n];
        boolean[][] g = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] != '.'){
                    f[i][a[i][j]-'1'] = true;
                    g[j][a[i][j]-'1'] = true;
                }
            }
        }
        backtrack(0, f, g, a);
    }
    
    boolean backtrack(int k, boolean[][] f, boolean[][] g, char[][] a){
        int n = 9;
        if(k >= n*n){
            return true;
        }
        
        int row = k/n;
        int col = k%n;
        if(a[row][col] != '.'){
            return backtrack(k+1, f, g, a);
        }else{
            for(int i=0;i<n;i++){
                if(!f[row][i] && !g[col][i] && isValid(a, row, col, i)){
                    f[row][i] = true;
                    g[col][i] = true;
                    a[row][col] = (char) (i + '1');
                    if(backtrack(k+1, f, g, a)){
                        return true;
                    }
                    a[row][col] = '.';
                    f[row][i] = false;
                    g[col][i] = false;
                }
            }
        }
        return false;
    }
    
    boolean isValid(char[][] a, int row, int col, int k){
        int x = (row/3)*3;
        int y = (col/3)*3;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(a[i][j] != '.' && a[i][j] == (char)(k+'1')){
                    return false;
                }
            }
        }
        return true;
    }
}
