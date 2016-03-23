package third;

import java.util.*;

/**
 * Print all unique combination of factors (except 1) of a given number.

 For example:
 Input: 12
 Output: [[2, 2, 3], [2, 6], [3, 4]]
 Input: 15
 Output: [[3, 5]]
 Input: 28 Output: [[2, 2, 7], [2, 14], [4, 7]]
 */
public class FactorCombination {
    public List<List<Integer>> combineFactors_simple(int n){
        if(n<=3) return new ArrayList<List<Integer>>();

        Map<Integer, List<List<Integer>>> map = new HashMap();
        return calc(n, map);
    }

    private List<List<Integer>> calc(int n, Map<Integer, List<List<Integer>>> map) {
        if(map.containsKey(n)) return map.get(n);

        List<List<Integer>> r = new ArrayList();
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                r.add(Arrays.asList(i, n / i));
                for(List<Integer> sub : calc(n/i, map)) {
                    List<Integer> dup = new ArrayList(sub);
                    dup.add(0, i);
                    r.add(dup);
                }
            }
        }
        map.put(n, r);
        return r;
    }

    /**
     * Get all combinations of numbers < n
     */
    List<List<Integer>> combineFactors(int n) {
        List<List<Integer>> r = new ArrayList();
        List<Integer> sub = new ArrayList();
        backtrack(n, sub, r, 1, 2);

        return r;
    }

    void backtrack(int n, List<Integer> sub, List<List<Integer>> r, int prod, int pos) {
        if(prod == n) {
            r.add(new ArrayList(sub));
        } else {
            for(int i=pos;i<n;i++) {
                if(prod*i>n) break;
                if(n%i != 0) continue;

                sub.add(i);
                backtrack(n, sub, r, prod*i, pos);
                sub.remove(sub.size()-1);
            }
        }
    }

    /**
     * Get all prime numbers of n, and try all combinations.
     * Be careful:
     *   1. Should not contain duplicate
     */
    List<List<Integer>> combineFactors_slow(int n) {
        List<List<Integer>> r = new ArrayList();
        if(n <= 1) return r;

        Map<Integer, Integer> map = factors(n);
        List<Integer> nums = new ArrayList(map.keySet());
        Collections.sort(nums);

        int total = 0;
        for(int x : map.values()) {
            total += x;
        }

        List<Integer> sub = new ArrayList();
        for(int i=2;i<=total;i++) {
            backtrack_slow(nums, map, 0, i, n, sub, r);
        }
        return r;
    }

    private void backtrack_slow(List<Integer> nums, Map<Integer, Integer> map, int pos, int total, int n, List<Integer> sub, List<List<Integer>> r) {
        if(sub.size() + 1 == total) {
            List<Integer> l = new ArrayList(sub);
            for(int x : sub) {
                n = n/x;
            }
            l.add(n);
            Collections.sort(l);
            r.add(l);
        } else {
            for (int i = pos; i < nums.size(); i++) {
                int x = nums.get(i);
                if (map.get(x) <= 0) {
                    continue;
                }

                sub.add(x);
                map.put(x, map.get(x) - 1);
                backtrack_slow(nums, map, pos, total, n, sub, r);

                sub.remove(sub.size()-1);
                map.put(x, map.get(x)+1);
            }
        }
    }

    private Map<Integer, Integer> factors(int n) {
        Map<Integer, Integer> map = new HashMap();

        int p = 2;
        while(n > 1) {
            if(n%p == 0) {
                if(!map.containsKey(p)) {
                    map.put(p, 0);
                }
                map.put(p, map.get(p) + 1);

                n = n/p;
            } else {
                if(p == 2) {
                    p = 3;
                } else {
                    p += 2;
                }
            }
        }

        return map;
    }
}