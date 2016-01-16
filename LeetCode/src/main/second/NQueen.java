package second;

import java.util.ArrayList;

public class NQueen {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> r = new ArrayList<String[]>();
        if(n <= 0){
            return r;
        }
        
        boolean[] cols = new boolean[n];
        int[] rows = new int[n];
        backtrack(0, n, cols, rows, r);
        return r;
    }
    
    void backtrack(int k, int n, boolean[] cols, int[] rows, ArrayList<String[]> r){
        if(k >= n){
            addResult(rows, r);
        }else{
            for(int j=0;j<n;j++){
                if(!cols[j] && isValid(rows, k, j)){
                    cols[j] = true;
                    rows[k] = j;
                    backtrack(k+1, n, cols, rows, r);
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
    
    void addResult(int[] rows, ArrayList<String[]> r){
        int n = rows.length;
        String[] sub = new String[n];
        for(int i=0;i<n;i++){
            StringBuffer sb = new StringBuffer();
            for(int j=0;j<n;j++){
                if(j == rows[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            sub[i] = sb.toString();
        }
        r.add(sub);
    }
}
