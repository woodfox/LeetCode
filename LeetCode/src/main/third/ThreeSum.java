package third;

import java.util.*;

public class ThreeSum {
    /**
     * Use set to avoid adding duplicated in twoSum.
     *
     * Time: O(n^2)
     */
    public List<List<Integer>> threeSum(int[] a) {
        int n = a.length;
        List<List<Integer>> r = new ArrayList();
        if(n<3) return r;

        Arrays.sort(a);
        int i = 0;
        while(i<n){
            for(List<Integer> l : twoSum(a, i+1, n-1, -a[i])){
                l.add(0, a[i]);
                r.add(l);
            }
            i++;
            while(i<n && a[i] == a[i-1]) i++;
        }
        return r;
    }

    List<List<Integer>> twoSum(int[] a, int l, int r, int t){
        Set<Integer> set = new HashSet();
        List<List<Integer>> result = new ArrayList();
        while(l<r){
            if(a[l] + a[r] == t){
                if(!set.contains(a[l])){
                    set.add(a[l]);
                    List<Integer> sub = new ArrayList();
                    sub.add(a[l]);
                    sub.add(a[r]);
                    result.add(sub);
                }
                l++;
                r--;
            } else if(a[l] + a[r] < t) {
                l++;
            } else {
                r--;
            }
        }

        return result;
    }

    // O(n^2)
    public List<List<Integer>> threeSum_complex(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length < 3){
            return result;
        }
        Arrays.sort(num);

        for(int i=0;i<num.length;i++){
            if(i > 0 && num[i] == num[i-1]){
                continue;
            }

            List<List<Integer>> twoSums = twoSum(num, i+1, num[i] * -1);
            for(List<Integer> l : twoSums) {
                l.add(0, num[i]);
                result.add(l);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] num, int pos, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = pos;
        int end = num.length-1;
        while(start < end) {
            if(start > pos && num[start] == num[start-1]){
                start++;
                continue;
            }
            if(end < num.length-1 && num[end] == num[end+1]){
                end--;
                continue;
            }
            if(num[start] + num[end] == sum){
                List<Integer> l = new ArrayList<Integer>();
                l.add(num[start]);
                l.add(num[end]);
                result.add(l);

                start++;
                end--;
            }else if(num[start] + num[end] < sum) {
                start++;
            }else{
                end--;
            }
        }
        return result;
    }
}
