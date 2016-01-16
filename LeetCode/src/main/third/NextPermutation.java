package third;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length <= 1) return;

        for(int i=num.length-2;i>=0;i--){
            int pos = -1;
            int min = Integer.MAX_VALUE;
            for(int j=i+1;j<num.length;j++){
                if(num[j] > num[i] && num[j] < min) {
                    pos = j;
                    min = num[j];
                }
            }

            if(pos != -1){
                int tmp = num[i];
                num[i] = num[pos];
                num[pos] = tmp;
                //Danger: Sort toIndex is exclusive!! same as subString
                Arrays.sort(num, i+1, num.length);

                return;
            }
        }

        Arrays.sort(num);
    }
}
