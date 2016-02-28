package third;

public class SingleNumber {
    /**
     * One way: use Map to save at first time, and remove it at second time;
     * Another way: Use number ^ number = 0
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums) {
            result ^= num;
        }

        return result;
    }
}
