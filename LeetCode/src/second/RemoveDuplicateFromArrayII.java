package second;

public class RemoveDuplicateFromArrayII {
    public int removeDuplicates(int[] a) {
        if(a.length == 0){
            return 0;
        }
        
        int n = a.length;
        int p = -1;
        int q = 0;
        while(q < n){
            a[++p] = a[q++];
            if(q < n && a[q] == a[p]){
                a[++p] = a[q++];
            }
            while(q < n && a[q] == a[p]){
                q++;
            }
        }
        return p+1;
    }
}
