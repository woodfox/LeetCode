package second;

public class SearchInRotatedArrayI {
    public int search(int[] a, int t) {
        int n = a.length;
        if(n == 0){
            return -1;
        }
        return binarySearch(a, 0, n-1, t);
    }
    
    int binarySearch(int[] a, int start, int end, int t){
        if(start > end){
            return -1;
        }
        int m = (start + end)/2;
        if(t == a[m]){
            return m;
        }else if(t < a[m]){
            if(t >= a[start] || a[start] > a[m]){
                return binarySearch(a, start, m-1, t);
            }else{
                return binarySearch(a, m+1, end, t);
            }
        }else{
            if(t <= a[end] || a[m] > a[end]){
                return binarySearch(a, m+1, end, t);
            }else{
                return binarySearch(a, start, m-1, t);
            }
        }
    }
}
