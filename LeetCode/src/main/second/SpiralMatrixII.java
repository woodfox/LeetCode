package second;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] a = new int[n][n];
        int x = 1;
        for(int i=0;i<=(n-1)/2;i++){
            int l = n-2*i;
            fill(a, i, l, x);
            x += 4*(l-1);
        }
        return a;
    }
    
    void fill(int[][] a, int k, int n, int x){
        if(n == 1){
            a[k][k] = x;
        }else {
            for(int i=1;i<n;i++){
                a[k][k+i-1] = x++;
            }
            for(int i=1;i<n;i++){
                a[k+i-1][k+n-1] = x++;
            }
            for(int i=1;i<n;i++){
                a[k+n-1][k+n-i] = x++;
            }
            for(int i=1;i<n;i++){
                a[k+n-i][k] = x++;
            }
        }
    }
}
