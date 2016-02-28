package third;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

 Ensure that numbers within the set are sorted in ascending order.


 Example 1:

 Input: k = 3, n = 7

 Output:

 [[1,2,4]]

 Example 2:

 Input: k = 3, n = 9

 Output:

 [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> sub = new ArrayList();
        List<List<Integer>> r = new ArrayList();
        backtrack(0, 1, k, n, sub, r);
        return r;
    }

    private void backtrack(int sum, int num, int k, int n, List<Integer> sub, List<List<Integer>> r) {
        if(sum == n && sub.size() == k) {
            r.add(new ArrayList(sub));
            return;
        }

        if(sum > n || sub.size() >= k) {
            return;
        }

        // Fill the last element directly to improve performance
        if(sub.size() == k-1) {
            if(n-sum >= num && n-sum <= 9) {
                sub.add(n-sum);
                backtrack(n, n-sum, k, n, sub, r);
                sub.remove(sub.size()-1);
            }
            return;
        }

        for(int i=num;i<=9;i++) {
            sub.add(i);
            backtrack(sum+i, i+1, k, n, sub, r);
            sub.remove(sub.size()-1);
        }
    }
}

