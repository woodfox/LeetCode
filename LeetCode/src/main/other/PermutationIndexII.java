package other;

import java.util.*;

/**
 * Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers,
 * which are ordered in lexicographical order. The index begins at 1.
 *
 * C(n-1) = (n-1)!/A1!/A2!..*k, k is the total of unique numbers less than current number, A1/A2.. is the duplicated numbers
 */
public class PermutationIndexII {
    /**
     * Special handling for duplicated numbers.
     * Use HashSet to save unique smaller numbers for nums[j], and use HashMap to get duplicated count of one number.
     *   index += Sum(smallerCount*(m-1)!/(A1!*A2!..))), A1/A2.. is the duplicated count in the remaining
     *
     * Time: O(n^2)
     */
    public long permutationIndexII(int[] a) {
        List<Integer> l = new ArrayList();
        for(int x: a) l.add(x);
        Collections.sort(l);

        Map<Integer, Integer> map = new HashMap();
        for(int x : a){
            if(!map.containsKey(x)) map.put(x, 0);
            map.put(x, map.get(x)+1);
        }

        int n = a.length;
        long factor = factor(n-1);
        long index = 1;
        for(int i=0;i<n-1;i++){
            int m = l.size();
            int j = 0;
            int smallerCount = 0;
            while(j<m && l.get(j) != a[i]){
                smallerCount++;
                j++;
            }

            long duplicatedFactor = 1;
            for(int count: map.values()) {
                if(count > 0) {
                    duplicatedFactor *= factor(count);
                }
            }
            // For every smaller number, we need to exclude the duplicated cases: (m-1)!/(A1!*A2!..)
            index += smallerCount*factor/duplicatedFactor;

            // Update factor by removing one
            factor = factor/(m-1);
            int x = l.remove(j);
            // Update map count
            map.put(x, map.get(x)-1);
        }
        return index;
    }

    private long factor(int n){
        if(n<=1) return (long)1;
        return n*factor(n-1);
    }

    /**
     * Brute force way to find previous smaller numbers one by one.
     * Time limit exceeded
     *
     * Time: O(k*n*logn)
     */
    public long permutationIndexII_slow(int[] a) {
        int index = 1;
        while(findPrev(a)){
            index++;
        }
        return index;
    }

    private boolean findPrev(int[] a){
        int n = a.length;
        int i = n-2;
        while(i>=0 && a[i]<=a[i+1]){
            i--;
        }
        if(i<0) return false;

        int j = i+1;
        while(j+1<n && a[j+1]<a[i]){
            j++;
        }
        swap(a, i, j);
        // Sort a[i+1,n-1] as descending
        Arrays.sort(a, i+1, n-1);
        reverse(a, i+1, n-1);
        return true;
    }

    private void reverse(int[] a, int left, int right){
        while(left<right){
            swap(a, left++, right--);
        }
    }

    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
