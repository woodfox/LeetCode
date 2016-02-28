package third;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++) a[i]++;
        for(int x : a) {
            int y = Math.abs(x);
            if(y-1 < n) a[y-1] *= -1;
        }

        for(int i=0;i<n;i++){
            if(a[i] > 0) return i;
        }
        return n;
    }
}
