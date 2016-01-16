package second;

public class SearchInsertPosition {
    public int searchInsert(int[] a, int t) {
        int n = a.length;
        if(n <= 0){
            return 0;
        }
        return binarySearch(a, 0, n-1, t);
    }
    
    int binarySearch(int[] a, int start, int end, int t){
        if(start > end){
            return start;
        }
        
        int m = (start + end)/2;
        if(a[m] == t){
            return m;
        }else if(a[m] > t){
            return binarySearch(a, start, m-1, t);
        }else{
            return binarySearch(a, m+1, end, t);
        }
    }
}
