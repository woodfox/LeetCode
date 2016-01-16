package first;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreakII {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		ArrayList<String> r = new ArrayList<String>();
		ArrayList<String> sub = new ArrayList<String>();
		Set<String> unmatch = new HashSet<String>();
		if (s == null || s.length() == 0) {
			return r;
		}
		breakWord(s, dict, unmatch, sub, r);
		return r;
	}

	boolean breakWord(String s, Set<String> dict, Set<String> unmatch,
			ArrayList<String> sub, ArrayList<String> r) {
		if (dict.contains(s)) {
			sub.add(s);
			addResult(sub, r);
			sub.remove(sub.size() - 1);
			return true;
		} else if (unmatch.contains(s)) {
			return false;
		}
		boolean flag = false;
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (dict.contains(left)) {
				sub.add(left);
				if (breakWord(right, dict, unmatch, sub, r)) {
					flag = true;
				}
				sub.remove(sub.size() - 1);
			}
		}
		if (!flag) {
			unmatch.add(s);
			return false;
		}
		return true;
	}

	void addResult(ArrayList<String> sub, ArrayList<String> r) {
		StringBuffer sb = new StringBuffer();
		for (String s : sub) {
			sb.append(s + " ");
		}
		r.add(sb.substring(0, sb.length() - 1));
	}
	
	public static void main(String[] args){
		System.out.println("sub:".substring(4));
	}
}
