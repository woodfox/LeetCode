package other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a permutation which contains no repeated number, find its index in all the permutations of these numbers,
 * which are ordered in lexicographical order. The index begins at 1.
 *  C(n-1) = (n-1)!*k, k is the total of numbers less than current number.
 */
public class PermutationIndex {
    /**
     * Compare the current array and sorted array and calculate the index.
     * For example,  [1,4,2,5,3] vs sorted [1,2,3,4,5], for number 4, there are 2*3! index beore.
     * Factor calculation can be enhanced by reusing.
     *
     * Time: O(n^2) in worse case
     */
    public long permutationIndex(int[] a) {
        List<Integer> l = new ArrayList();
        for(int x: a) l.add(x);
        Collections.sort(l);

        int n = a.length;
        long index = 1;
        for(int i=0;i<n-1;i++){
            int j = 0;
            int m = l.size();
            while(j<m && l.get(j) != a[i]){
                j++;
            }
            if(j!=0){
                index += j*factor(m-1);
            }
            l.remove(j);
        }
        return index;
    }

    private long factor(int n){
        if(n==1) return (long)1;
        return n*factor(n-1);
    }
}
