package second;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] a, int t) {
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.length-3;i++){
            if(i>0 && a[i] == a[i-1]){
                continue;
            }
            
            for(int j=i+1;j<a.length-2;j++){
                if(j>i+1 && a[j] == a[j-1]){
                    continue;
                }
                for(ArrayList<Integer> sub : twoSum(a, j, t-a[i]-a[j])){
                    sub.add(0, a[j]);
                    sub.add(0, a[i]);
                    r.add(sub);
                }
            }
        }
        return r;
    }
    
	ArrayList<ArrayList<Integer>> twoSum(int[] a, int p, int t) {
		ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
		int i = p + 1;
		int j = a.length - 1;
		while (i < j) {
			if (i > p + 1 && a[i] == a[i - 1]) {
				i++;
				continue;
			}
			if (j < a.length - 1 && a[j] == a[j + 1]) {
				j--;
				continue;
			}

			if (a[i] + a[j] == t) {
				ArrayList<Integer> sub = new ArrayList<Integer>();
				sub.add(a[i]);
				sub.add(a[j]);
				r.add(sub);
				i++;
				j--;
			} else if (a[i] + a[j] < t) {
				i++;
			} else {
				j--;
			}
		}
		return r;
	}
    
    public static void main(String[] args){
    	FourSum f = new FourSum();
    	int[] a = {-495,-482,-455,-447,-400,-388,-381,-360,-350,-340,-330,-317,-308,-300,-279,-235,-209,-206,-188,-186,-171,-145,-143,-141,-137,-129,-121,-115,-97,-56,-47,-28,-20,-19,8,11,35,41,46,50,69,84,85,86,88,91,135,160,171,172,177,190,226,234,238,244,249,253,254,272,281,284,294,296,300,303,307,313,320,320,327,334,355,362,367,401,426,436,456,467,473,473,484};
    	System.out.println(f.fourSum(a, -7178));
    }
}
