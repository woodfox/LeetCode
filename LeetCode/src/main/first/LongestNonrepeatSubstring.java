package first;
import java.util.HashMap;
import java.util.HashSet;

public class LongestNonrepeatSubstring {
	//Precalculate duplicated position with time O(n)
    public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }
        
        int n = s.length();
        int[] duplicatePos = new int[n];
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(map.get(c) == null){
                duplicatePos[i] = -1;
                map.put(c, i);
            }else{
                int pos = map.get(c);
                duplicatePos[i] = pos;
                map.put(c, i);
            }
        }
        
        int[] dp = new int[n];
        int max = 1;
        dp[0] = 1;
        for(int i=1;i<n;i++){
            if(duplicatePos[i] < i-dp[i-1]){
                dp[i] = dp[i-1] + 1;
            }else{
                dp[i] = i - duplicatePos[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }
        
        return max;
    }
    
	//Brute force with time O(n^2)
	public int lengthOfLongestSubstringForce(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) {
			return 0;
		} else if (s.length() == 1) {
			return 1;
		}

		int n = s.length();
		int max = 0;
		for (int i = 0; i < n - 1; i++) {
			int count = 1;
			HashSet<Character> set = new HashSet<Character>();
			set.add(s.charAt(i));
			for (int j = i + 1; j < n; j++) {
				if (set.contains(s.charAt(j))) {
					break;
				}
				count++;
				set.add(s.charAt(j));
			}

			if (count > max) {
				max = count;
			}
		}

		return max;
	}
	
	public static void main(String[] args){
		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s));
	}
}
