package third;

public class RangeSumQuery {
    private int[] sum;
    public RangeSumQuery(int[] a) {
        int n = a.length;
        sum = new int[n];
        if(n > 0) {
            sum[0] = a[0];
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + a[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i==0){
            return sum[j];
        } else {
            return sum[j] - sum[i-1];
        }
    }

    //Brute force
    //Query Time: O(n)
//    private int[] a;
//    public RangeSumQuery(int[] a) {
//        this.a = a;
//    }
//
//    public int sumRange(int i, int j) {
//        int sum = 0;
//        for(int k=i;k<=j;k++) {
//            sum += a[k];
//        }
//        return sum;
//    }
}
