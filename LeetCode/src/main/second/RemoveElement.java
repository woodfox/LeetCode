package second;

public class RemoveElement {
    public int removeElement(int[] a, int t) {
        int n = a.length;
        if(n == 0){
            return 0;
        }
        
        int p = 0;
        for(int i=0;i<n;i++){
            if(a[i] != t){
                a[p++] = a[i];
            }
        }
        return p;
    }
}
