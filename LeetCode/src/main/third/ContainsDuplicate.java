package third;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for(int n : nums) {
            if(!set.contains(n)) {
                set.add(n);
            } else {
                return true;
            }
        }

        return false;
    }
}
