package third;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i >=0 || j >= 0){
            int x = Integer.MIN_VALUE;
            if(i>=0) x = nums1[i];

            int y = Integer.MIN_VALUE;
            if(j>=0) y = nums2[j];

            if(x >= y){
                nums1[pos] = x;
                i--;
            }else{
                nums1[pos] = y;
                j--;
            }
            pos--;
        }
    }
}
