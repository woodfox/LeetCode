package second;

public class RemoveDuplicateFromArray {
    public int removeDuplicates(int[] a) {
        if(a.length == 0){
            return 0;
        }
        
        int n = a.length;
        int p = 0;
        int q = 1;
        while(q < n){
            while(q < n && a[q] == a[p]){
                q++;
            }
            if(q < n){
                a[++p] = a[q++];
            }
        }
        return p+1;
    }
}
