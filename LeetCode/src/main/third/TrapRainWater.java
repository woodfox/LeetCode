package third;

public class TrapRainWater {
    /**
     * Move from the lowest edge compared by left and right, and calculate any water.
     */
    public int trap(int[] a) {
        if(a == null || a.length <= 2) return 0;

        int sum = 0;
        int left = 0;
        int right = a.length - 1;
        int min = Math.min(a[left], a[right]);
        while(left < right - 1) {
            if(a[left] <= a[right]) {
                left++;
                if(min >= a[left]){
                    sum += min - a[left];
                }else{
                    min = Math.min(a[left], a[right]);
                }

            }else{
                right--;
                if(min >= a[right]){
                    sum += min - a[right];
                }else{
                    min = Math.min(a[left], a[right]);
                }
            }
        }

        return sum;
    }
}
