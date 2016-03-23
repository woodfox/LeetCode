package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSeq {
    /**
     * Get digit one by one according to k and total digits.
     *
     * Time: O(n)
     */
    public String getPermutation(int n, int k) {
        if(n==1) return "1";
        List<Integer> l = new ArrayList();
        for(int i=1;i<=n;i++){
            l.add(i);
        }
        int[] total = new int[n+1];
        total[0] = 1;
        for(int i=1;i<=n;i++){
            total[i] = total[i-1]*i;
        }
        return getKth(l, k-1, total);
    }

    private String getKth(List<Integer> l, int k, int[] total) {
        int n = l.size();
        if(n==0) return "";

        StringBuffer sb = new StringBuffer();
        int pos = k/total[n-1];
        sb.append(l.remove(pos));
        sb.append(getKth(l, k%total[n-1], total));

        return sb.toString();
    }

    /**
     * Find the next larger number by swapping two digits.
     *
     * Time: O(kn)
     */
    public String getPermutation_byNext(int n, int k) {
        if(n==1) return "1";
        char[] a = new char[n];
        for(int i=1;i<=n;i++){
            a[i-1] = (char)('0' + i);
        }
        for(int i=0;i<k-1;i++){
            getNext(a);
        }
        return new String(a);
    }

    private void getNext(char[] a) {
        int n = a.length;
        int i = n-2;
        while(i>=0 && a[i] >= a[i+1]) {
            i--;
        }

        if(i<0) {
            // Restore back to first number if k is too large
            Arrays.sort(a);
        } else {
            int j = n-1;
            while(a[j] < a[i]) j--;
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            Arrays.sort(a, i+1, n);
        }
    }
}
