package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    //O(n^3)
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length < 4){
            return result;
        }

        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            if(isEqual(num, i, i - 1, 0)) continue;

            for(int j=i+1;j<num.length-2;j++){
                if(isEqual(num, j, j - 1, i+1)) continue;

                List<List<Integer>> twoElements = twoSum(num, j+1, target - num[i] - num[j]);
                for(List<Integer> l : twoElements){
                    l.add(0, num[i]);
                    l.add(1, num[j]);
                    result.add(l);
                }
            }
        }

        return result;
    }

    private boolean isEqual(int[] num, int pos, int compare, int start) {
        return (compare >= start && compare < num.length && num[pos] == num[compare]);
    }

    private List<List<Integer>> twoSum(int[] num, int pos, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int start = pos;
        int end = num.length -1;
        while(start < end) {
            if(isEqual(num, start, start - 1, pos)) {
                start++;
                continue;
            }
            if(isEqual(num, end, end + 1, pos)) {
                end--;
                continue;
            }

            int sum = num[start] + num[end];
            if(sum == target) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(num[start]);
                l.add(num[end]);
                result.add(l);

                start++;
                end--;
            }else if(sum < target) {
                start++;
            }else{
                end--;
            }
        }

        return result;
    }
}
