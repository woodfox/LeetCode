package second;

public class ContainerWithMostWater {
    public int maxArea(int[] a) {
        int n = a.length;
        if(n <= 1){
            return 0;
        }
        int i = 0;
        int j = n-1;
        int max = 0;
        while(i < j){
            int x = Math.min(a[i], a[j]) * (j-i);
            max = Math.max(max, x);
            if(a[i] <= a[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
