package third;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] a) {
        int n = a.length;
        if(n == 0) return 0;

        Arrays.sort(a);
        reverse(a);

        int i = 0;
        while(i<n && a[i] >= i+1) {
            i++;
        }
        return i;
    }

    private void reverse(int[] a) {
        int l = 0;
        int r = a.length-1;
        while(l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            l++;
            r--;
        }
    }
}
