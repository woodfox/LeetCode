package first;
import java.util.ArrayList;
import java.util.List;

public class AllPartition {	
	void backtrack(ArrayList<ArrayList<String>> r, List<String> l, String s){
		if(s == null|| s.length()== 0){
			r.add(new ArrayList<String>(l));
		}else{
			List<String> c = constructCandidate(s);
			for(String t:c){
				l.add(t);
				if(t.length() < s.length()){
					backtrack(r, l, s.substring(t.length(), s.length()));
				}else{
					backtrack(r, l, null);
				}
				
				//Remove previous value before new candidate
				l.remove(l.size() - 1);
			}
		}
	}
	
	List<String> constructCandidate(String s){
		List<String> l = new ArrayList<String>();
		for(int i=1;i<=s.length();i++){
			String t = s.substring(0, i);
			if(t.equals(reverse(t))){
				l.add(t);
			}
		}
		return l;
	}
	
	String reverse(String s){
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1;i>=0;i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
	public ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
		List<String> l = new ArrayList<String>();
		backtrack(r, l, s);
		return r;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AllPartition p = new AllPartition();
		System.out.println(p.partition("aabbaa"));
		System.out.println(p.partition("aabb"));
		System.out.println(p.partition("abab"));
		System.out.println(p.partition("abacdc"));
		System.out.println(p.partition("xabcdcbyz"));
		System.out.println(p.partition("abadadab"));
		System.out.println(p.partition("abcd"));
	}

}
