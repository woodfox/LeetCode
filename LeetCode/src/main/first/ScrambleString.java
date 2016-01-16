package first;
public class ScrambleString {	
	//Use Dynamic Programming with time O(n^3)
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() != s2.length()) {
    		return false;
		} else if (s1.length() == 0) {
			return true;
		} else if (s1.equals(s2)) {
			return true;
		} else if (isReverseEqual(s1, s2)) {
			return true;
		}
        
        int n = s1.length();
        boolean[][][] m = new boolean[n][n][n];
        for(int k=1;k<=n;k++){
            for(int i=0;i<=n-k;i++){
                for(int j=0;j<=n-k;j++){
                    if(k == 1){
                        m[k-1][i][j] = (s1.charAt(i) == s2.charAt(j));
                    }else {
                        m[k-1][i][j] = false;
                        for(int x=1;x<k;x++){
                            if(m[x-1][i][j] && m[k-x-1][i+x][j+x]){
                                m[k-1][i][j] = true;
                            }
                            if(m[x-1][i][j+k-x] && m[k-x-1][i+x][j]){
                                m[k-1][i][j] = true;
                            }
                        }
                    }
                
                }
            }            
        }
        return m[n-1][0][0];
    }
    
	//Brute force to check if two strings are scramble string
	//This will throw Time Limited Error for large data set!
	public boolean isScrambleForce(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() != s2.length()) {
			return false;
		} else if (s1.length() == 0) {
			return true;
		} else if (s1.equals(s2)) {
			return true;
		} else if (isReverseEqual(s1, s2)) {
			return true;
		}

		int n = s1.length();
		for (int i = 1; i < s1.length(); i++) {
			String l1 = s1.substring(0, i);
			String r1 = s1.substring(i);
			String l2 = s2.substring(0, i);			
			String r2 = s2.substring(i);
			if (isScrambleForce(l1, l2) && isScrambleForce(r1, r2)) {
				System.out.println(l1 + "|" + r1 + "," + l2 + "|" + r2); 
				return true;
			}

			String l3 = s2.substring(n - i);
			String r3 = s2.substring(0, n - i);
			if (isScrambleForce(l1, l3) && isScrambleForce(r1, r3)) {
				System.out.println(l1 + "|" + r1 + "," + r3 + "|" + l3);
				return true;
			}
		}

		return false;
	}

	boolean isReverseEqual(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(s2.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		ScrambleString s = new ScrambleString();
		System.out.println(s.isScrambleForce("cbcccccbbabcbac", "bbccaccbcbcabcc"));
	}
}
