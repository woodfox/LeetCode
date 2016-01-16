package second;

public class WordSearch {
    public boolean exist(char[][] a, String s) {
        int m = a.length;
        if(m == 0){
            return false;
        }
        int n = a[0].length;
        if(n == 0){
            return false;
        }
        if(s == null || s.length() == 0){
            return true;
        }
        
        boolean[][] flag = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(a, s, i, j, 0, flag)){
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean dfs(char[][] a, String s, int row, int col, int k, boolean[][] flag){
        if(k >= s.length()){
            return true;
        }
        
        int m = a.length;
        int n = a[0].length;
        
        if(row < 0 || row >= m || col < 0 || col >= n
          || flag[row][col] || a[row][col] != s.charAt(k)){
              return false;
        }
        
        flag[row][col] = true;
        if(dfs(a, s, row+1, col, k+1, flag)
        || dfs(a, s, row-1, col, k+1, flag)
        || dfs(a, s, row, col+1, k+1, flag)
        || dfs(a, s, row, col-1, k+1, flag)){
            return true;
        }
        flag[row][col] = false;
        return false;
    }
}
