package first;
import java.util.Arrays;

public class ThreeSumCloset {
	public int threeSumClosest(int[] a, int t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Arrays.sort(a);
		long min = Integer.MAX_VALUE;
		for (int i = 0; i <= a.length - 3; i++) {
			long x = twoSumCloset(a, i, t - a[i]);
			if (Math.abs(x + a[i] - t) < Math.abs(min - t)) {
				min = x + a[i];
			}
		}
		return (int)min;
	}

	long twoSumCloset(int[] a, int p, int t) {
		long closet = Integer.MAX_VALUE;
		int i = p+1;
        int j = a.length-1;
        while(i < j){
            if(Math.abs(a[i] + a[j] - t) < Math.abs(closet - t)){
                closet = a[i] + a[j];
            }
            if(a[i] + a[j] == t){
                return t;
            }else if(a[i] + a[j] > t){
                j--;
            }else {
                i++;
            }
        }
		return closet;
	}
	
	public static void main(String[] args){
		ThreeSumCloset t = new ThreeSumCloset();
		int[] a = {1, 1, 1, 0};
		System.out.println(t.threeSumClosest(a, 100));
	}
}
