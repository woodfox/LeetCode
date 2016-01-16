package third;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int pos = 0;
        int actual = 0;
        int count = 0;

        while(pos < nums.length) {
            if(pos == 0 || nums[pos] != nums[pos-1]){
                count = 0;
            }

            count++;
            // Move element if it's not duplicated more than two times
            if(count <= 2) {
                nums[actual] = nums[pos];
                actual++;
            }

            pos++;
        }
        return actual;
    }
}
