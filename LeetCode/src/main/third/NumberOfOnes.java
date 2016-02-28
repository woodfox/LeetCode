package third;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOfOnes {
    public int hammingWeight(int n) {
        int total = 0;
        for(int i=0;i<32;i++) {
            if((n&1) > 0) {
                total++;
            }
            n >>= 1;
        }
        return total;
    }
}
