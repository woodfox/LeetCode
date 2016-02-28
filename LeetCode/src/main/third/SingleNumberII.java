package third;

public class SingleNumberII {
    /**
     * calculate the single digit i which is not divided by 3.
     * Please note the exception number should exist for 1 or 2 times (can not be 6/9... times).
     */
    public int singleNumber(int[] nums) {
        int[] array = new int[32];
        for(int i=0;i<32;i++) {
            for(int num : nums) {
                array[i] += (num >> i)&1;
            }

            array[i] = array[i]%3;
        }

        int result = 0;
        for(int i=0;i<32;i++) {
            if(array[i] > 0) {
                result += (1 << i);
            }
        }

        return result;
    }
}
