package third;

/**
 * Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?
 */
public class ReverseBits {
    /**
     * Best solution!!
     */
    public int reverseBits(int n) {
        int r = 0;
        for(int i=0;i<32;i++) {
            r <<= 1;
            r = r | (n&1);
            n >>= 1;
        }
        return r;
    }

    /**
     * Enhanced version:
     * Reverse 4 digits together and cache the reversed value based on old value.
     */
    public int reverseBits_fast(int n) {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int r = 0;
        for(int i=0;i<8;i++) {
            r <<= 4;
            int right = n%16;
            r = r | a[right];
            n >>= 4;
        }
        return r;
    }

    /**
     * Be careful:
     * 1. Can not use result > 0 to get bit!!
     */
    public int reverseBits_complicated(int n) {
        int start = 0;
        int end = 31;
        while(start < end) {
            boolean a = getBit(n, start);
            boolean b = getBit(n, end);
            if(a != b) {
                n = reverseBit(n, start);
                n = reverseBit(n, end);
            }
            start++;
            end--;
        }
        return n;
    }

    boolean getBit(int n, int p) {
        // Not > 0!!!
        return (n & (1<<p)) != 0;
    }

    int reverseBit(int n, int p){
        return n^(1<<p);
    }
}
