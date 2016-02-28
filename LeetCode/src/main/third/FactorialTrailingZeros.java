package third;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeros {
    /**
     * Find the number of 5 in factors.
     *
     * f(n) = floor(n/5) + floor(n/25) + floor(n/125)...
     *
     */
    public int trailingZeroes(int n) {
        long x = 5;
        int count = 0;
        while(n >= x) {
            count += n/x;
            x = x*5;
        }
        return count;
    }
}
