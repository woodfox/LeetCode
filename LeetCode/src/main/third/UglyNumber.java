package third;

/**
 * Write a program to check whether a given number is an ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

 Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if(num < 1) return false;
        int[] p = {2,3,5};

        int i = 0;
        while(i < 3 && num > 1) {
            if(num%p[i] == 0) {
                num = num/p[i];
            } else {
                i++;
            }
        }

        return (i < 3);
    }
}
