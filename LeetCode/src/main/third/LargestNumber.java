package third;

import java.util.*;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    /**
     * Compare two string with different order directly!!
     *
     *
     * Time: O(m*nlgn) , m = length of numbers; n = total numbers;
     */
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        // PreCondition: nums.length >= 1
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums) {
            list.add(num);
        }
        Collections.sort(list, new NumberComparator());

        StringBuffer sb = new StringBuffer();
        for(int x : list) {
            sb.append(x);
        }

        if(sb.charAt(0) == '0') {
            return "0";
        } else {
            return sb.toString();
        }
    }

    class NumberComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String a = o1.toString();
            String b = o2.toString();

            // if a+b is smaller than b+a, it should use b+a (bigger first)
            return (a+b).compareTo(b+a)*-1;
        }
    }
}
