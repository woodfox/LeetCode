package third;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {
    /**
     * result repeats from 1 to 9 from number 10.
     */
    public int addDigits(int num) {
        if(num < 10) return num;
        return (num-10)%9 + 1;
    }
}
