package third;

/**
 * Given an integer, write a function to determine if it is a power of two
 */
public class PowerOfTwo {
    /**
     * Another way is compare with (2<<i),  0 <= i < 31
     *
     * Be careful:
     *   1. n is negative!!
     */
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        } else if(n == 1) {
            return true;
        } else {
            while(n > 2) {
                if(n%2 != 0) {
                    return false;
                }
                n = n/2;
            }

            return true;
        }
    }
}
