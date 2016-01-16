package second;

public class MedianOfSortedArray {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if(m == 0 && n == 0){
            return -1;
        }
        
        if((m+n)%2 == 1){
            return findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1);
        }else{
            return (double)((findKth(a, 0, m-1, b, 0, n-1, (m+n)/2) 
            + (findKth(a, 0, m-1, b, 0, n-1, (m+n)/2+1))))/2;
        }
    }
    
    int findKth(int[] a, int sa, int ea, int[] b, int sb, int eb, int k){
        if(ea - sa > eb - sb){
            return findKth(b, sb, eb, a, sa, ea, k);
        }
        
        if(ea < sa){
            return b[sb+k-1];
        }else if(k == 1){
            return Math.min(a[sa], b[sb]);
        }
        
        int l = Math.min(k/2, ea-sa+1);
        int pa = sa + l;
        int pb = sb + (k-l);
        if(a[pa-1] == b[pb-1]){
            return a[pa-1];
        }else if(a[pa-1] < b[pb-1]){
            return findKth(a, pa, ea, b, sb, pb-1, k-l);
        }else{
            return findKth(a, sa, pa-1, b, pb, eb, l);
        }
    }
    
    public static void main(String[] args){
    	MedianOfSortedArray m = new MedianOfSortedArray();
    	int[] a = {100000};
    	int[] b = {100001};
    	System.out.println(m.findMedianSortedArrays(a, b));
    	
    	double d = (double)((2+3))/2;
    	System.out.println(d);
    }
}
