package third;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    /**
     * Major voting algorithm for n/3.
     * It will select two elements which shows most frequently. If there is other element, reduce the two count;
     * In worse case (1,1,1), it will get any two of three.
     * At last, it needs to verify whehter it's real > n/3.
     *
     * Time: O(n), Space: O(1)
     */
    public List<Integer> majorityElement(int[] nums) {
        int a = -1;
        int count1 = 0;
        int b = -1;
        int count2 = 0;

        for(int x : nums) {
            if(x == a) {
                count1++;
            } else if(x == b) {
                count2++;
            } else if(count1 == 0) {
                a = x;
                count1++;
            } else if(count2 == 0) {
                b = x;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int n = nums.length;
        count1 = 0;
        count2 = 0;
        for(int x : nums) {
            if(x == a) {
                count1++;
            } else if(x == b) {
                count2++;
            }
        }

        List<Integer> r = new ArrayList();
        if(count1 > n/3) {
            r.add(a);
        }
        if(count2 > n/3) {
            r.add(b);
        }

        return r;
    }
}
