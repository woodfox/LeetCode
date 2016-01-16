package second;

public class SearchRange {
    public int[] searchRange(int[] a, int t) {
        int n = a.length;
        int[] r = {-1, -1};
        if(n == 0){
            return r;
        }
        return binarySearch(a, 0, n-1, t);
    }
    
    int[] binarySearch(int[] a, int start, int end, int t){
        int[] r = new int[2];
        if(start > end){
            r[0] = -1;
            r[1] = -1;
        }else{
            int m = (start + end)/2;
            if(a[m] == t){
                int i = m;
                while(i >= start && a[i] == t){
                    i--;
                }
                int j = m;
                while(j <= end && a[j] == t){
                    j++;
                }
                r[0] = i+1;
                r[1] = j-1;
            }else if(a[m] > t){
                return binarySearch(a, start, m-1, t);
            }else{
                return binarySearch(a, m+1, end, t);
            }
        }
        return r;
    }
}
