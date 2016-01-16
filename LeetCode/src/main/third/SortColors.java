package third;

public class SortColors {
    // Using two pointers with one passes
    public void sortColors(int[] nums) {
        int n = nums.length;
        if(n == 0) return;

        int zeroPos = 0;
        int twoPos = n-1;
        int i=0;
        // Do not swap again after twoPos!
        while(i <= twoPos){
            if(nums[i] == 0){
                swap(nums, zeroPos, i);
                zeroPos++;
                i++;
            }else if(nums[i] == 2){
                swap(nums, twoPos, i);
                twoPos--;
            }else{
                i++;
            }
        }
    }

    void swap(int[] nums, int pos1, int pos2){
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
    }

    // ============================================
    // Counting sort with two passes
    public void sortColors2(int[] nums) {
        int n = nums.length;
        if(n == 0) return;

        int[] counts = new int[3];
        for(int i : nums){
            counts[i]++;
        }

        int pos = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<counts[i];j++){
                nums[pos] = i;
                pos++;
            }
        }
    }
}
