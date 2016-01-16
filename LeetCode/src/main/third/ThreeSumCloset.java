package third;

import java.util.Arrays;

public class ThreeSumCloset {
    // O(n^2)
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(num);

        long closest = Integer.MAX_VALUE;
        for(int i=0;i<num.length-2;i++){
            int expected = target - num[i];

            int start = i+1;
            int end = num.length - 1;
            while(start < end) {
                int sum = num[start] + num[end] + num[i];
                if(Math.abs(sum - target) < Math.abs(closest - target)){
                    closest = sum;
                }
                if(num[start] + num[end] == expected) {
                    return target;
                }else if(num[start] + num[end] < expected) {
                    start++;
                }else{
                    end--;
                }
            }
        }

        return (int)closest;
    }
}
