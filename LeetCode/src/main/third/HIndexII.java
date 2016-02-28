package third;

public class HIndexII {
    public int hIndex(int[] a) {
        int n = a.length;
        if(n == 0) return 0;

        int i = n-1;
        while(i >= 0 && a[i] >= (n-i)){
            i--;
        }
        return n-i-1;
    }
}
