package third;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */
public class SingleNumberIII {
    /**
     * Xor all numbers to get a result (r) of two single numbes.
     * Then separate all numbers by the digit k in r, and xor them again to get x and y.
     *
     * Time: O(n), Space:O(1)
     */
    public int[] singleNumber(int[] a) {
        int r = 0;
        for(int x: a) {
            r ^= x;
        }

        int y = 1;
        while((y & r) == 0) {
            y <<= 1;
        }

        int r1 = 0;
        int r2 = 0;
        for(int x : a) {
            if((x & y) == 0){
                r1 ^= x;
            } else {
                r2 ^= x;
            }
        }

        return new int[]{r1, r2};
    }
}
