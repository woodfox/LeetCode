package first;
import java.util.LinkedList;

public class SimplifyPath {
	public String simplifyPath(String path) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (path == null) {
			return "/";
		}

		String[] a = path.split("/");
		LinkedList<String> q = new LinkedList<String>();
		for (String s : a) {
			if (s.equals("") || s.equals(".")) {
				continue;
			} else if (s.equals("..")) {
				if (!q.isEmpty()) {
					q.removeLast();
				}
			} else {
				q.add(s);
			}
		}

		StringBuffer sb = new StringBuffer();
		for (String s : q) {
			sb.append("/");
			sb.append(s);
		}
		if (q.isEmpty()) {
			sb.append("/");
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String[] a = "/a/b/c/".split("/");
		for(String s:a){
			System.out.println(s);
		}
		
	}
}
