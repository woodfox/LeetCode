package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class ThreeSum {
	// Another solution to reuse twoSum
	// Complexity isO(n^3)
    public ArrayList<ArrayList<Integer>> threeSum(int[] a) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(a);
        for(int i=0;i<=a.length-3;i++){
            if(i>0 && a[i] == a[i-1]){
                continue;
            }
            ArrayList<ArrayList<Integer>> two = twoSum(a, i, -1*a[i]);
            for(ArrayList<Integer> l : two){
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(a[i]);
                sub.addAll(l);
                r.add(sub);
            }
        }
        return r;
    }
    
    ArrayList<ArrayList<Integer>> twoSum(int[] a, int p, int t){
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=p+1;i<a.length;i++){
            if(map.get(a[i]) != null){
                if(i > p + 1 && a[i] == a[i-1] && r.size() > 0){
                    continue;
                }
                ArrayList<Integer> sub = new ArrayList<Integer>();
                sub.add(t-a[i]);
                sub.add(a[i]);
                r.add(sub);
            }else{
                map.put(t-a[i], i);
            }
        }
        return r;
    }

	// This solution is too complicated in logic
	public ArrayList<ArrayList<Integer>> threeSum2(int[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sub = new ArrayList<Integer>();
		Arrays.sort(a);

		for (int i = 0; i <= a.length - 2; i++) {
			int x = a[i];
			if (i > 0 && a[i] == a[i - 1]) {
				continue;
			}

			ArrayList<ArrayList<Integer>> twoSum = getTwoSum(a, i);
			for (ArrayList<Integer> l : twoSum) {
				sub.add(x);
				sub.addAll(l);
				addResult(sub, r);
				sub.clear();
			}
		}

		return r;
	}

	void addResult(ArrayList<Integer> sub, ArrayList<ArrayList<Integer>> r) {
		ArrayList<Integer> dup = new ArrayList<Integer>(sub);
		Collections.sort(dup);
		r.add(dup);
	}

	ArrayList<ArrayList<Integer>> getTwoSum(int[] a, int pos) {
		int t = a[pos];
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		for (int i = pos + 1; i < a.length; i++) {
			if (i > pos + 1 && a[i] == a[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < a.length; j++) {
				if (j > i + 1 && a[j] == a[j - 1]) {
					continue;
				}
				if (a[i] + a[j] == -1 * t) {
					ArrayList<Integer> sub = new ArrayList<Integer>();
					sub.add(a[i]);
					sub.add(a[j]);
					r.add(sub);
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		int[] a = { 0, 0, 0, 0 };
		System.out.println(t.threeSum(a));

		int[] b = { -4, -1, 0, 2, -1, 1 };
		System.out.println(t.threeSum(b));
	}
}
