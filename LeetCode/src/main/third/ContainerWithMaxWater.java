package third;

public class ContainerWithMaxWater {
    // Performance improved with O(n)
    public int maxArea(int[] height) {
        int n = height.length;
        if(n < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = n-1;
        while(left < right){
            int minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight*(right - left));

            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }

    //Brute force with O(n^2)
    public int maxAreaBruteForce(int[] height) {
        int n = height.length;
        if(n < 2) {
            return 0;
        }

        int max = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight*(j-i));
            }
        }
        return max;
    }
}
