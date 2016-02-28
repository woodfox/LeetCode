package third;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

 For example:
 Given n = 13,
 Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberOfDigitOne {
    /**
     * Check the left-most digit d (n/x):
     *   1. if d > 1 then it include d * (number between 0~ x-1) + extra-ones in (1000, 1001,...) + ones in remaining number
     *     f(n) = d*f(x-1) + x + f(n%x);
     *   2. if d == 1 then it include (number between 0 ~ x-1) + extra-ones in (1000, 1001, ... n) + ones in remaining number
     *     f(n) = f(x-1) + n%x + 1 + f(n%x);
     *
     * Be careful:
     *  1. Use divide to avoid integer overflow
     */
    public int countDigitOne(int n) {
        if(n <= 0) {
            return 0;
        } else if(n>=1 && n <= 9) {
            return 1;
        } else {
            int x = 1;
            while(n/10 >= x){
                x = x*10;
            }

            if(n/x > 1) {
                return (n/x) * countDigitOne(x-1) + x + countDigitOne(n%x);
            } else {
                return countDigitOne(x-1) + n%x + 1 + countDigitOne(n%x);
            }
        }
    }
}
