package third;

public class FindMissingPositive {
    // Danger: the value in array may already be negative!!
    public int firstMissingPositive(int[] a) {
        int n = a.length;
        for(int i=0;i<n;i++){
            if(a[i] <= 0) a[i] = n+1;
        }
        for(int i=0;i<n;i++){
            int value = Math.abs(a[i]);
            int pos = value - 1;
            if(value <= n) a[pos] = Math.abs(a[pos]) * -1;
        }
        for(int i=0;i<n;i++){
            if(a[i] > 0) return i+1;
        }
        return n+1;
    }
}
