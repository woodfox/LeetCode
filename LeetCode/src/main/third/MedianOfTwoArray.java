package third;

public class MedianOfTwoArray {
    public double findMedianSortedArrays(int a[], int b[]) {
        int m = a.length;
        int n = b.length;
        if(m == 0 && n == 0){
            return -1;
        }

        if((m+n)%2 == 1)
            return findKth(a, 0, m-1, b, 0, n-1, (m+n+1)/2);
        else
            return (double)(findKth(a, 0, m-1, b, 0, n-1, (m+n)/2) + findKth(a, 0, m-1, b, 0, n-1, (m+n)/2 + 1))/2;
    }

    private int findKth(int[] a, int startA, int endA, int[] b, int startB, int endB, int k) {
        if(endA - startA > endB - startB) {
            return findKth(b, startB, endB, a, startA, endA, k);
        }

        if(startA > endA){
            return b[startB + k - 1];
        }else if(startB > endB) {
            return a[startA + k -1];
        }else if(k == 1){
            return Math.min(a[startA], b[startB]);
        }

        int length = Math.min(k/2, endA - startA + 1);
        int posA = startA + length - 1;
        int posB = startB + (k - length) - 1;
        if(a[posA] == b[posB]) {
            return a[posA];
        }else if(a[posA] < b[posB]){
            return findKth(a, posA+1, endA, b, startB, posB, k - length);
        }else{
            return findKth(a, startA, posA, b, posB+1, endB, length);
        }
    }

}
