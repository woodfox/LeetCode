package third;

import util.Range;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Get the maximum range size in unsorted array
 */
public class MaximumRange {
    /**
     * Use startMap and endMap to maintain ranges, and increase/merge the range if possible
     */
    public int maximumRange(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }

        Map<Integer, Range> startMap = new HashMap<Integer, Range>();
        Map<Integer, Range> endMap = new HashMap<Integer, Range>();
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums) {
            // Avoid duplicated elements to create smaller range again
            if(set.contains(num)) {
                continue;
            }
            set.add(num);

            if(endMap.containsKey(num-1)) {
                // Extend range right
                Range r = endMap.remove(num - 1);
                r.end = num;
                endMap.put(num, r);

                // merge if possible
                merge(startMap, endMap, num);
            } else if(startMap.containsKey(num+1)) {
                // Extend range left
                Range r = startMap.remove(num+1);
                r.start = num;
                startMap.put(num, r);
            } else {
                Range r = new Range(num, num);
                startMap.put(num, r);
                endMap.put(num, r);
            }
        }

        int max = 0;
        for(Range r : startMap.values()) {
            max = Math.max(max, r.end-r.start);
        }
        return max;
    }

    private void merge(Map<Integer, Range> startMap, Map<Integer, Range> endMap, int num) {
        if(startMap.containsKey(num+1)) {
            Range left = endMap.remove(num);
            Range right = startMap.remove(num+1);

            left.end = right.end;
            startMap.put(left.start, left);
            endMap.put(left.end, left);
        }
    }
}
