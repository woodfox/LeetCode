package other;

import java.util.Arrays;

public class PermuationSequence {
    public String getPermutation(int n, int k) {
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
            while(a[j] <= a[i]) j--;
            char tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            Arrays.sort(a, i+1, n);
        }
    }
}
