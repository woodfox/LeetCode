package second;

public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] a, int t) {
        int m = a.length;
        if(m == 0){
            return false;
        }
        int n = a[0].length;
        if(n == 0){
            return false;
        }
        return binarySearch(a, t, 0, m*n-1);
    }
    
    boolean binarySearch(int[][] a, int t, int start, int end){
        if(start <= end){
            int m = (start+end)/2;
            int row = m/a[0].length;
            int col = m%a[0].length;
            if(t == a[row][col]){
                return true;
            }else if(t < a[row][col]){
                return binarySearch(a, t, start, m-1);
            }else{
                return binarySearch(a, t, m+1, end);
            }
        }
        return false;
    }
}
