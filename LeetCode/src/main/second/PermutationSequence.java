package second;

import java.util.ArrayList;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            l.add(i);
        }
        int[] a = new int[n];
        a[0] = 1;
        for(int i=1;i<n;i++){
            a[i] = a[i-1]*i;
        }
        generate(n, k-1, l, sb, a);
        return sb.toString();
    }
    
    void generate(int n, int k, ArrayList<Integer> l, StringBuffer sb, int[] a){
        if(k == 0){
            for(int i:l){
                sb.append(i);
            }
        }else if(n == 1){
            sb.append(l.get(0));
        }else{
            int i = k/a[n-1];
            k = k%a[n-1];
            sb.append(l.get(i));
            l.remove(i);
            generate(n-1, k, l, sb, a);
        }
    }
}
