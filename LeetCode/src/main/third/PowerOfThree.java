package third;

/**
 * Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        while(true) {
            if(n == 1) return true;
            else if(n%3 != 0) return false;
            else n = n/3;
        }
    }

    public boolean isPowerOfThree_withoutLoop(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }

}
