package second;


public class NQueenII {
int total = 0;
    
    public int totalNQueens(int n) {
        total = 0;
        if(n <= 0){
            return total;
        }
        
        boolean[] cols = new boolean[n];
        int[] rows = new int[n];
        backtrack(0, n, cols, rows);
        return total;
    }
    
    void backtrack(int k, int n, boolean[] cols, int[] rows){
        if(k >= n){
            total++;
        }else{
            for(int j=0;j<n;j++){
                if(!cols[j] && isValid(rows, k, j)){
                    cols[j] = true;
                    rows[k] = j;
                    backtrack(k+1, n, cols, rows);
                    cols[j] = false;
                }
            }
        }
    }
    
    boolean isValid(int[] rows, int i, int j){
        int n =rows.length;
        for(int k=1;i-k>=0;k++){
            if(j-k >= 0 && rows[i-k] == j-k){
                return false;
            }
            if(j+k < n && rows[i-k] == j+k){
                return false;
            }
        }
        return true;
    }
}
