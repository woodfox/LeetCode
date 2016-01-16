package second;

import java.util.LinkedList;

public class PlusOne {
    public int[] plusOne(int[] a) {
        int n = a.length;
        if(n == 0){
            return a;
        }
        LinkedList<Integer> q = new LinkedList<Integer>();
        int added = 1;
        for(int i=n-1;i>=0;i--){
            int r = a[i] + added;
            q.addFirst(r%10);
            added = r/10;
        }
        if(added > 0){
            q.addFirst(added);
        }
        
        int[] b = new int[q.size()];
        for(int i=0;i<q.size();i++){
            b[i] = q.get(i);
        }
        return b;
    }
}
