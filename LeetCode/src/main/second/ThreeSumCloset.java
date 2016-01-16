package second;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] a, int t) {
        Arrays.sort(a);
        int closet = Integer.MAX_VALUE;
        for(int i=0;i<a.length-2;i++){
            if(i>0 && a[i] == a[i-1]){
                continue;
            }
            int sum = twoSumCloset(a, i+1, t-a[i]);
            if(closet == Integer.MAX_VALUE || Math.abs(closet-t) > Math.abs(a[i]+sum-t)){
                closet = a[i] + sum;
            }
        }
        return closet;
    }
    
    int twoSumCloset(int[] a, int p, int t){
        int i = p;
        int j = a.length-1;
        int closet = Integer.MAX_VALUE;
        while(i<j){
            if(closet == Integer.MAX_VALUE || Math.abs(closet-t) > Math.abs(a[i]+a[j]-t)){
                closet = a[i] + a[j];
            }
            if(a[i]+a[j] > t){
                j--;
            }else{
                i++;
            }
        }
        return closet;
    }
}
