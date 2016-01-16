package third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] num) {
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
