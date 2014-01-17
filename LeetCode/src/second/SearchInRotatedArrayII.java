package second;

public class SearchInRotatedArrayII {
    public boolean search(int[] a, int t) {
        int n = a.length;
        if(n == 0){
            return false;
        }
        return binarySearch(a, 0, n-1, t);
    }
    
    boolean binarySearch(int[] a, int start, int end, int t){
        if(start > end){
            return false;
        }
        int m = (start + end)/2;
        if(t == a[m]){
            return true;
        }else if(t < a[m]){
            while(start < m && a[start] == a[m]){
                start++;
            }
            if(t >= a[start] || a[start] > a[m]){
                return binarySearch(a, start, m-1, t);
            }else{
                return binarySearch(a, m+1, end, t);
            }
        }else{
            while(end > m&& a[end] == a[m]){
                end--;
            }
            if(t <= a[end] || a[m] > a[end]){
                return binarySearch(a, m+1, end, t);
            }else{
                return binarySearch(a, start, m-1, t);
            }
        }
    }
}
