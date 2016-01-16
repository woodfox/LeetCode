package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	//Compute character counts and also sum to reduce calculation time
	public ArrayList<String> anagrams(String[] a) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		int n = a.length;
		if (n == 0) {
			return result;
		}

		Arrays.sort(a, new StringLengthComparator());

		boolean[] flag = new boolean[n];
		ArrayList<HashMap<Character, Integer>> countList = getCounts(a);
		long[] sum = getSums(countList);

		for (int i = 0; i < n; i++) {
			if (flag[i]) {
				continue;
			}
			String s = a[i];
			for (int j = i + 1; j < n; j++) {
				if (flag[j]) {
					continue;
				}
				String t = a[j];
				if (s.length() != t.length()) {
					break;
				}
				if (isAnagram(countList, sum, i, j)) {
					result.add(a[j]);
					flag[j] = true;

					if (!flag[i]) {
						result.add(a[i]);
						flag[i] = true;
					}
				}
			}
			flag[i] = true;
		}
		return result;
	}

	boolean isAnagram(List<HashMap<Character, Integer>> countList, long[] sum,
			int i, int j) {
		if (sum[i] != sum[j]) {
			return false;
		}

		HashMap<Character, Integer> c1 = countList.get(i);
		HashMap<Character, Integer> c2 = countList.get(j);
        for(char c: c1.keySet()){
            Integer v1 = c1.get(c);
            Integer v2 = c2.get(c);
            if(v2 == null || v1 != v2){
                return false;
            }
        }
        for(char c: c2.keySet()){
            Integer v1 = c1.get(c);
            Integer v2 = c2.get(c);
            if(v1 == null || v1 != v2){
                return false;
            }
        }
		return true;
	}

	ArrayList<HashMap<Character, Integer>> getCounts(String[] a) {
		ArrayList<HashMap<Character, Integer>> counts = new ArrayList<HashMap<Character, Integer>>();
		for (String s : a) {
			HashMap<Character, Integer> count = new HashMap<Character, Integer>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				Integer n = count.get(c);
				if (n == null) {
					n = 0;
				}
				count.put(c, n + 1);
			}
			counts.add(count);
		}
		return counts;
	}

	long[] getSums(ArrayList<HashMap<Character, Integer>> counts) {
		long[] sums = new long[counts.size()];
		int i = 0;
		for (HashMap<Character, Integer> count : counts) {
			for (Map.Entry<Character, Integer> entry : count.entrySet()) {
				char c = entry.getKey();
				int v = entry.getValue();
				sums[i] += (c - '0') * 100 + v;
			}
			i++;
		}
		return sums;
	}

	private class StringLengthComparator implements Comparator<String> {
		public int compare(String a, String b) {
			if (a.length() <= b.length()) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public static void main(String[] args){
		String[] a = {"cat","rye","aye","cud","cat","old","fop","dlo"};
		Anagram an = new Anagram();
		System.out.println(an.anagrams(a));
	}
}
