package other;

import java.util.Arrays;

/**
 * Find how many of x+y+z<t in the array.
 */
public class ThreeSumLess {
    int threeSumLess(int[] a, int t) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for(int i=0;i<n-2;i++){
            count += twoSumLess(a, i+1, t-a[i]);
        }
        return count;
    }

    private int twoSumLess(int[] a, int p, int t) {
        int n = a.length;
        int r = 0;
        int start = p;
        int end = n-1;
        while(start < end) {
            if(a[start] + a[end] < t) {
                r += end - start;
                start++;
            } else {
                end--;
            }
        }

        return r;
    }
}
