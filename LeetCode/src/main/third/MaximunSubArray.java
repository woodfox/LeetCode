package third;

public class MaximunSubArray {
    public int maxSubArray(int[] a) {
        if(a == null || a.length == 0) return Integer.MIN_VALUE;

        int n = a.length;
        int[] max = new int[n];
        max[0] = a[0];
        int result = max[0];
        for(int i=1;i<n;i++){
            max[i] = Math.max(max[i-1], 0) + a[i];
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
