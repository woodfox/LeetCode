package second;

public class RotateImage {
    public void rotate(int[][] a) {
        int n = a.length;
        if(n == 0){
            return;
        }
        for(int k=0;k<=(n-1)/2;k++){
            move(a, k, n-2*k);
        }
    }
    
    void move(int[][] a, int k, int n){
        for(int i=0;i<n-1;i++){
            int tmp = a[k][k+i];
            a[k][k+i] = a[k+n-1-i][k];
            a[k+n-1-i][k] = a[k+n-1][k+n-1-i];
            a[k+n-1][k+n-1-i] = a[k+i][k+n-1];
            a[k+i][k+n-1] = tmp;
        }
    }
}
