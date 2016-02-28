package third;

import util.Range;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        if(nums.length == 0) {
            return result;
        }

        Range r = new Range(nums[0], nums[0]);
        for(int i=1;i<nums.length;i++) {
            if(nums[i] == r.end+1) {
                r.end += 1;
            } else {
                addRange(r, result);
                r = new Range(nums[i], nums[i]);
            }
        }
        // Add last range
        addRange(r, result);

        return result;
    }

    private void addRange(Range r, List<String> result) {
        if(r.start == r.end) {
            result.add(r.start + "");
        } else {
            result.add(r.start + "->" + r.end);
        }
    }
}
