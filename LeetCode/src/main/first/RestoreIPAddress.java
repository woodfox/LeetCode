package first;
import java.util.ArrayList;

public class RestoreIPAddress {
	ArrayList<String> result;

	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		result = new ArrayList<String>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		backtrack(s, t, 0, 0);
		return result;
	}

	void backtrack(String s, ArrayList<Integer> t, int i, int pos) {
		if (i == 4) {
			result.add(t.get(0) + "." + t.get(1) + "." + t.get(2) + "."
					+ t.get(3));
		} else {
			ArrayList<Integer> c = getCandicate(s, i, pos);
			for (int j : c) {
				t.add(j);
				backtrack(s, t, i + 1, pos + ("" + j).length());
				t.remove(t.size() - 1);
			}
		}
	}

	ArrayList<Integer> getCandicate(String s, int i, int pos) {
		ArrayList<Integer> r = new ArrayList<Integer>();
		if (i == 3) {
    		if(pos >= s.length()){
                return r;
    		}
            int leftLength = s.length() - pos;
            if(leftLength > 3) {
            	return r;
            }
            if(leftLength > 1 && s.charAt(pos) == '0'){
                return r;
            }

			int ip = Integer.parseInt(s.substring(pos));
			if (ip < 256) {
				r.add(ip);
			}			
		} else {
			for (int j = 1; j < 4; j++) {
				if (pos + j > s.length()) {
					break;
				}

				int ip = Integer.parseInt(s.substring(pos, pos + j));
				if (ip < 256) {
					r.add(ip);
				}

				// Skip the number starting with 0
				if (j == 1 && s.charAt(pos) == '0') {
					break;
				}
			}
		}
		return r;
	}
	
	public static void main(String[] args){
		RestoreIPAddress r = new RestoreIPAddress();
		System.out.println(r.restoreIpAddresses("0279245587303"));
	}
}
