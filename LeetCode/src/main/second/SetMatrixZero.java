package second;

public class SetMatrixZero {
    public void setZeroes(int[][] a) {
        int m = a.length;
        if(m == 0){
            return;
        }
        int n = a[0].length;
        if(n == 0){
            return;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 0){
                    setAll(a, i, j);
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == -1){
                    a[i][j] = 0;
                }
            }
        }
    }
    
    void setAll(int[][] a, int row, int col){
        for(int i=0;i<a.length;i++){
            if(a[i][col] != 0){
                a[i][col] = -1;
            }
        }
        for(int i=0;i<a[0].length;i++){
            if(a[row][i] != 0){
                a[row][i] = -1;
            }
        }
    }
}
