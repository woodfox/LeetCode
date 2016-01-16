package first;

public class RotateImage {
    public void rotate(int[][] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = a.length;
        if (n == 0) {
            return;
        }
        
        for (int level = 0; level < n / 2; level++) {
            for (int k = level; k <= n - 2 - level; k++) {
                int tmp = a[level][k];
                a[level][k] = a[n - 1 - k][level];
                a[n - 1 - k][level] = a[n - 1 - level][n - 1 - k];
                a[n - 1 - level][n - 1 - k] = a[k][n - 1 - level];
                a[k][n - 1 - level] = tmp;
            }
        }
    }
    
    public static void main(String[] args){
        RotateImage r= new RotateImage();
        int[][] a = {{1,2}, {3,4}};
        r.rotate(a);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
