package first;
public class StrStr {
	//KMP algorithm with time complexity O(m+n)
	public String strStr(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        int m = p.length();
        if(m == 0 && n == 0){
            return "";
        }
        else if(n == 0){
            return null;
        }else if(m == 0){
            return s;
        }
        
        int[] pre = calcPrefix(p);
        int j = 0;
        for(int i=0;i<n;i++){
            while(j>0 && s.charAt(i) != p.charAt(j)){
                j = pre[j-1];
            }
            if(s.charAt(i) == p.charAt(j)){
                j++;
            }
            if(j == m){
                return s.substring(i-m+1);
            }
        }
        return null;
    }
    
    int[] calcPrefix(String p){
        int n = p.length();
        int[] pre = new int[n];
        pre[0] = 0;
        int j = 0;
        for(int i=1;i<n;i++){
            while(j>0 && p.charAt(i) != p.charAt(j)){
                j = pre[j-1];
            }
            
            if(p.charAt(i) == p.charAt(j)){
                j++;
            }
            pre[i] = j;
        }
        return pre;
    }
    
	//O(m*n). Will throw Memory Limit Exceeded for large data set!!
	public String strStr2(String haystack, String needle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = haystack.length();
		int n = needle.length();
		if (m == 0 && n == 0) {
			return "";
		} else if (m == 0) {
			return null;
		} else if (n == 0) {
			return haystack;
		}

		boolean[][] f = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (j == 0) {
					f[i][j] = true;
				} else if (i == 0) {
					f[i][j] = false;
				} else {
					f[i][j] = (haystack.charAt(i - 1) == needle.charAt(j - 1))
							&& f[i - 1][j - 1];
				}

				if (j == n && f[i][j]) {
					return haystack.substring(i - n);
				}
			}
		}
		return null;
	}

}
