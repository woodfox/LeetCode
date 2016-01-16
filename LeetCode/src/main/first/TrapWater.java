package first;

public class TrapWater {
    public int trap(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = a.length;
        if (n <= 1) {
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                left[i] = 0;
            }
            else {
                left[i] = Math.max(left[i - 1], a[i - 1]);
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = 0;
            }
            else {
                right[i] = Math.max(right[i + 1], a[i + 1]);
            }
        }
        
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 0 && right[i] > 0) {
                int min = Math.min(left[i], right[i]);
                if (min > a[i]) {
                    sum += min - a[i];
                }
            }
        }
        
        return sum;
    }
    
}
