package third;

import java.util.LinkedList;

public class LargestHistgram {
    /**
     * Calculate max length of greater elements in left and right, and then calculate max rectangle
     * combining left and right side.
     *
     * Time Complexity: O(n)
     */
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        else if(n == 1) return height[0];

        // Calculate the max length of elements that are greater than ith element in the left (excluding itself)
        int[] left = new int[n];
        left[0] = 0;
        int boundary = 0;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addFirst(boundary);
        for(int i=1;i<n;i++){
            while(!queue.isEmpty() && height[i] <= height[queue.getFirst()]){
                queue.removeFirst();
            }
            if(queue.isEmpty()){
                left[i] = i - boundary;
            }else{
                left[i] = i - queue.getFirst() - 1;
            }
            // Important: don't forget to add elements into queue!
            queue.addFirst(i);
        }

        // Calculate the max length of elements that are greater than ith element in the right (excluding itself)
        int[] right = new int[n];
        right[n-1] = 0;
        boundary = n-1;

        queue.clear();
        queue.addFirst(boundary);
        for(int i=n-2;i>=0;i--){
            while(!queue.isEmpty() && height[i] <= height[queue.getFirst()]){
                queue.removeFirst();
            }
            if(queue.isEmpty()){
                right[i] = boundary - i;
            }else{
                right[i] = queue.getFirst() - i - 1;
            }
            queue.addFirst(i);
        }

        int result = 0;
        for(int i=0;i<n;i++){
            int rectangle = height[i]*(left[i] + right[i] + 1);
            result = Math.max(result, rectangle);
        }
        return result;
    }

    /**
     * ===================================================================
     * Divide-And-Conqure with time complexity O(nlgn)
     */
    public int largestRectangleArea_nlgn(int[] height) {
        int n = height.length;
        return largest(height, 0, n-1);
    }

    private int largest(int[] height, int start, int end){
        if(start > end) return 0;

        int smallest = start;
        for(int i=start+1;i<=end;i++){
            if(height[i] < height[smallest]){
                smallest = i;
            }
        }
        int result = height[smallest] * (end-start+1);
        result = Math.max(result, largest(height, start, smallest-1));
        result = Math.max(result, largest(height, smallest+1, end));
        return result;
    }

    /**
     * ===================================================================
     * Smallest between (i, j):
     *  f(i, j) = | h[i]  if i==j
     *            | min(h(i, j-1), h[j])   if j - i > 0
     *
     * Time complexity: O(n^2)
     */
    public int largestRectangleArea_n2(int[] height) {
       int n = height.length;
        int[][] smallest = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(i == j){
                    smallest[i][j] = height[i];
                }else{
                    smallest[i][j] = Math.min(height[j], smallest[i][j-1]);
                }
            }
        }

        int start = 0;
        int end = n-1;
        int result = 0;
        while(start <= end){
            result = Math.max(result, smallest[start][end]*(end-start+1));
            if(height[start] <= height[end]){
                start++;
            }else{
                end--;
            }
        }

        return result;
    }
}
