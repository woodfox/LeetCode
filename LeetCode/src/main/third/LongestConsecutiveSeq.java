package third;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestConsecutiveSeq {
    private class Range {
        public int start;
        public int end;

        public Range(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * Best solution: Count the consecutive numbers for one element, and use a set to control
     * only one access for all elements.
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }

        int max = 0;
        for(int num : nums) {
            int count = 1;
            set.remove(num);

            int left = num-1;
            while(set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }

            int right = num+1;
            while(set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }

            max = Math.max(count, max);
        }
        return max;
    }

    /**
     *  Use Range to merge consecutive numbers.
     *    1. If number-1 exists in endMap, merge into endMap, then mergeMaps
     *    2. If number+1 exists in startMap, merge into startMap, then mergeMaps
     *    3. otherwise add Range(number, number) into startMap and endMap if not there
     *
     *  Time: O(N)
     */
    public int longestConsecutive_range(int[] nums) {
        Map<Integer, Range> startMap = new HashMap<Integer, Range>();
        Map<Integer, Range> endMap = new HashMap<Integer, Range>();
        for(int num : nums) {
            if(endMap.containsKey(num) || startMap.containsKey(num)) {
                continue;
            }

            boolean added = false;
            if(startMap.containsKey(num+1)) {
                Range r = startMap.remove(num+1);
                r.start = num;

                // Merge with previous range on left if any
                if(endMap.containsKey(r.start - 1)) {
                    Range left = endMap.remove(r.start-1);
                    r.start = left.start;
                }
                startMap.put(r.start, r);
                endMap.put(r.end, r);

                added = true;
            }

            if(endMap.containsKey(num-1)) {
                Range r = endMap.remove(num-1);
                r.end = num;

                // Merge with next range on right if any
                if(startMap.containsKey(r.end+1)) {
                    Range right = startMap.remove(r.end+1);
                    r.end = right.end;
                }
                startMap.put(r.start, r);
                endMap.put(r.end, r);

                added = true;
            }

            if(!added)  {
                Range r = new Range(num, num);
                startMap.put(num, r);
                endMap.put(num, r);
            }
        }

        int max = 0;
        for(Range r : startMap.values()) {
            max = Math.max(max, r.end - r.start + 1);
        }
        return max;
    }
}
