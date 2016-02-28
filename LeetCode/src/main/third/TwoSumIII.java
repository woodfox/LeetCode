package third;

import java.util.*;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add(input) – Add the number input to an internal data structure.

 find(value) – Find if there exists any pair of numbers which sum is equal to the value.

 For example, add(1); add(3); add(5); find(4)->true; find(7)->false
 */
public class TwoSumIII {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // O(1)
    public void add(int x) {
        Integer count = map.get(x);
        if(count == null) {
            count = 0;
        }
        map.put(x, count+1);
    }

    // O(n)
    public boolean find(int sum) {
        for(int x : map.keySet()) {
            int y = sum - x;
            if(x == y && map.get(x) > 1) {
                return true;
            } else {
                if(map.containsKey(y)) {
                    return true;
                }
            }
        }

        return false;
    }
}

class TwoSumIII_another {
    Set<Integer> set = new HashSet<Integer>();
    List<Integer> nums = new ArrayList<Integer>();

    // O(n)
    public void add(int x) {
        for(int num : nums) {
            set.add(x + num);
        }
        nums.add(x);
    }

    // O(1)
    public boolean find(int sum) {
        return set.contains(sum);
    }
}
