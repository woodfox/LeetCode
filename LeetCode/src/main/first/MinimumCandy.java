package first;
import java.util.Arrays;



public class MinimumCandy {
	public int candy(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a == null || a.length == 0){
        	return 0;
        }
        
        int n = a.length;
        int[] candy = new int[n];
        int pos = 0;
        while(pos < n){
            while(pos < n-1 && a[pos] > a[pos+1]){
                pos++;
            }
            candy[pos] = 1;
            pos++;
            while(pos < n && a[pos] > a[pos-1]){
                candy[pos] = candy[pos-1]+1;
                pos++;
            }
        }
        
        int sum = 0;
        for(int i=n-1;i>=0;i--){
            if(candy[i] == 0){
                candy[i] = candy[i+1] + 1;
                if(i>0 && candy[i-1] > 0 && a[i-1] > a[i]){
                    candy[i-1] = Math.max(candy[i-1], candy[i]+1);
                }
            }
            sum += candy[i];
        }
        
        System.out.println(Arrays.toString(candy));
        return sum;
    }
	
	//Wrong answer!! The same rating could have different candy
	//e.g, Rating: {1,2,2,3} ==> Candy: {1,2,1,2}
	public int candyWrong(int[] a) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(a == null || a.length == 0){
        	return 0;
        }
        
        int n = a.length;
        int[] candy = new int[n];
        candy[0] = 1;
        int pos = 0;
        while(pos < n){
        	int low = pos;
        	while(low < n -1 && a[low] >= a[low+1]){
        		low++;
        	}
        	if(low > pos){
        		candy[low] = 1;
        		for(int i=low-1;i>pos;i--){
        			if(a[i] == a[i+1]){
        				candy[i] = candy[i+1];
        			}else{
        				candy[i] = candy[i+1] + 1;
        			}
        		}
        		int tmp = candy[pos+1]+1;
        		if(a[pos] == a[pos+1]){
        			tmp = candy[pos+1];
        		}
        		candy[pos] = Math.max(candy[pos], tmp);
        	}
        	
        	pos = low+1;
        	while(pos < n){
        		if(a[pos] == a[pos-1]){
        			candy[pos] = candy[pos-1];
        		}else if(a[pos] > a[pos-1]){
        			candy[pos] = candy[pos-1]+1;
        		}else{
        			pos--;
        			break;
        		}
        		pos++;
        	}
        }
        
        //System.out.println(Arrays.toString(candy));
        int sum = 0;
        for(int count: candy){
        	sum += count;
        }
        
        return sum;
    }
	
	public static void main(String[] args){
		MinimumCandy m = new MinimumCandy();
		int[] a = {1,2,3,4,5,6};
		System.out.println("Expected 21, Actual:" + m.candy(a));
		
		int[] b = {6,5,4,3,2,1};
		System.out.println("Expected 21, Actual:" + m.candy(b));
		
		int[] c = {1,4,5,6,4,3,2};
		System.out.println("Expected 16, Actual:" + m.candy(c));
		
		int[] d = {1,2,2,3,4,4,5,6,6,4,3,3,2,1,5,7,8,9,9};
		System.out.println("Expected 65, Actual:" + m.candy(d));
		
		int[] e = {6};
		System.out.println("Expected 1, Actual:" + m.candy(e));
		
		int[] f = {5,6};
		System.out.println("Expected 3, Actual:" + m.candy(f));
		
		int[] g = {5,6,5};
		System.out.println("Expected 4, Actual:" + m.candy(g));
		
		int[] h = {2,2,1};
		System.out.println("Expected 4, Actual:" + m.candy(h));
	}
}
