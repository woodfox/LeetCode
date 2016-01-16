package first;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
	//Collect the max width on the left and right for each tab (height >= h[i])
	//Time complexity is O(n)
    public int largestRectangleArea(int[] h) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Integer> left = new LinkedList<Integer>();
        int[] l = new int[h.length];
        for(int i=0;i<h.length;i++){
            l[i] = 1;
            while(!left.isEmpty() && h[i] <= h[left.peek()]){
                left.removeFirst();
            }
            if(left.isEmpty()){
                l[i] += i;
            }else{
                l[i] += (i - left.peek() -1);
            }
            left.addFirst(i);
        }
        
        LinkedList<Integer> right = new LinkedList<Integer>();
        int[] r= new int[h.length];
        for(int i=h.length-1;i>=0;i--){
            r[i] = 0;
            while(!right.isEmpty() && h[i] <= h[right.peek()]){
                right.removeFirst();
            }
            if(right.isEmpty()){
                r[i] += h.length - 1 - i;
            }else {
                r[i] += right.peek() -i - 1;
            }
            right.addFirst(i);
        }
        
        int max = 0;
        for(int i=0;i<h.length;i++){
            max = Math.max(max, h[i] * (l[i] + r[i]));
        }
        return max;
    }
    
	//Separate to left and right part and get their largest rectangle accordingly
	//Time is O(n^2), will throw Runtime Error for large data sest!!
	public int largestRectangleArea1(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (height.length == 0) {
			return 0;
		}
		return largestRectangle(height, 0, height.length - 1);
	}

	int largestRectangle(int[] h, int start, int end) {
		if (end == start) {
			return h[start];
		}

		int p = findLowestHeight(h, start, end);
		int size = h[p] * (end - start + 1);
		if (p > start) {
			int left = largestRectangle(h, start, p - 1);
			size = Math.max(size, left);
		}
		if (p < end) {
			int right = largestRectangle(h, p + 1, end);
			size = Math.max(size, right);
		}

		return size;
	}

	int findLowestHeight(int[] h, int start, int end) {
		int l = start;
		for (int i = start + 1; i <= end; i++) {
			if (h[i] < h[l]) {
				l = i;
			}
		}
		return l;
	}
}
