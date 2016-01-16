package second;

import java.util.LinkedList;

public class LargestHistgram {
	//O(n)
    public int largestRectangleArea(int[] a) {
        if(a == null || a.length == 0){
            return 0;
        }
        int n = a.length;
        int[] l = new int[n];
        LinkedList<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty() && a[i] <= a[q.peek()]){
                q.removeFirst();
            }
            
            if(q.isEmpty()){
                l[i] = i;
            }else{
                l[i] = i - q.peek() - 1;
            }
            q.addFirst(i);
        }
        
        
        int[] r = new int[n];
        q.clear();
        for(int i=n-1;i>=0;i--){
            while(!q.isEmpty() && a[i] <= a[q.peek()]){
                q.removeFirst();
            }
            if(q.isEmpty()){
                r[i] = n-i-1;
            }else{
                r[i] = q.peek() - i - 1;
            }
            q.addFirst(i);
        }
        
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, (l[i]+r[i]+1)*a[i]);
        }
        return max;
    }
    
	//TLE, with O(n^2)
    public int largestRectangleArea2(int[] a) {
        int max = 0;
        if(a == null || a.length == 0){
            return 0;
        }
        int n = a.length;
        for(int i=0;i<n;i++){
            int left = 0;
            for(int j=i-1;j>=0;j--){
                if(a[j] < a[i]){
                    break;
                }
                left++;
            }
            
            int right = 0;
            for(int j=i+1;j<n;j++){
                if(a[j] < a[i]){
                    break;
                }
                right++;
            }
            
            max = Math.max(max, a[i]*(left+right+1));
        }
        
        return max;
    }
}
