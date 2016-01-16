package second;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] a) {
        int n = 9;
        
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] block = new boolean[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] != '.'){
                    int blockNum = (i/3)*3 + (j/3);
                    if(row[i][a[i][j] - '1'] || col[j][a[i][j] - '1'] || block[blockNum][a[i][j]-'1']){
                        return false;
                    }
                    
                    row[i][a[i][j] - '1'] = true;
                    col[j][a[i][j] - '1'] = true;
                    block[blockNum][a[i][j]-'1'] = true;
                }
            }
        }
        return true;
    }
    
	//TLE if backtrack to find solution
    public boolean isValidSudoku2(char[][] a) {
        int n = 9;
        for(int i=0;i<n;i++){
            if(!validSub(a, i)){
                return false;
            }
        }
        return true;
    }
    
    boolean validSub(char[][] a, int k){
        int row = (k/3)*3;
        int col = (k%3)*3;
        boolean[] f = new boolean[9];
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(a[i][j] != '.'){
                    f[a[i][j] - '1'] = true;
                }
            }
        }
        return backtrack(0, row, col, a, f);
    }
    
    boolean backtrack(int k, int row, int col, char[][] a, boolean[] f){
        if(k >= 9){
            return validSubSum(a, row, col);
        }else{
            int i=k/3;
            int j = k%3;
            if(a[row+i][col+j] != '.'){
                return backtrack(k+1, row, col, a, f);
            }else{
                for(int x=0;x<9;x++){
                    if(!f[x]){
                        f[x] = true;
                        a[row+i][col+j] = (char)(x+'1');
                        if(backtrack(k+1, row, col, a, f)){
                            return true;
                        }
                        f[x] = false;
                        a[row+i][col+j] = '.';
                    }
                }
                return false;
            }
        }
    }
    
    boolean validSubSum(char[][] a, int row, int col){
        int x = a[row][col] + a[row][col+1] + a[row][col+2];
        for(int i=1;i<3;i++){
            if(x != a[row+i][col] + a[row+i][col+1] + a[row+i][col+2]) {
                return false;
            }
        }
        
        x = a[row][col] + a[row+1][col] + a[row+2][col];
        for(int i=1;i<3;i++){
            if(x != a[row][col+i] + a[row+1][col+i] + a[row+2][col+i]){
                return false;
            }
        }
        return true;
    }
}
