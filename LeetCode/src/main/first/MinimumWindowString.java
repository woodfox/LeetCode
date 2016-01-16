package first;
public class MinimumWindowString {
	//Remove first character and find next character if necessary
	//Time complexity is O(n)
    public String minWindow(String s, String t) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = s.length();
        int n = t.length();
        if(m < n){
            return "";
        }
        
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for(int i=0;i<n;i++){
            count2[t.charAt(i)]++;
        }
        int j = 0;
        for(;j<m;j++){
            count1[s.charAt(j)]++;
            if(contains(count1, count2)){
                break;
            }
        }
        
        int start = -1;
        int end = -1;
        int min = Integer.MAX_VALUE;
        int i=0;
        while(j < m){
            if(min > j-i+1){
                min = j-i+1;
                start = i;
                end = j;
            }
            char c = s.charAt(i);
            i++;
            count1[c]--;
            
            if(count1[c] < count2[c]){
                j = j + 1;
                while(j < m){
                    count1[s.charAt(j)]++;
                    if(s.charAt(j) == c){
                        break;
                    }
                    j++;
                }
            }
        }
        
        if(start > -1){
            return s.substring(start, end+1);
        }else{
            return "";
        }
    }
    
    boolean contains(int[] count1, int[] count2){
        for(int i=0;i<count2.length;i++){
            if(count1[i] < count2[i]){
                return false;
            }
        }
        return true;
    }
    
	//Brute Search with time O(n^2), will throw Time Limited Exceed error!!
	public String minWindowBrute(String s, String t) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = s.length();
		int n = t.length();
		if (m < n) {
			return "";
		}

		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= m - n; i++) {
			int[] count = new int[256];
			for (int j = 0; j < n; j++) {
				count[t.charAt(j)]++;
			}

			for (int j = i; j < m; j++) {
				count[s.charAt(j)]--;
				if (checkContains(count)) {
					if (min > j - i + 1) {
						min = j - i + 1;
						start = i;
						end = j;
					}
				}
			}
		}

		if (start > -1) {
			return s.substring(start, end + 1);
		} else {
			return "";
		}
	}

	boolean checkContains(int[] count) {
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
