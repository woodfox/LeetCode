package first;
public class InterleaveString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
		if(!checkCharCount(s1, s2, s3)) {
			return false;
		}
		
		int m = s1.length();
		int n = s2.length();
		boolean[][] matrix = new boolean[m+1][n+1];
		for(int i=m;i>=0;i--){
			for(int j=n;j>=0;j--){
				if(i == m && j == n){
					matrix[i][j] = true;
				}else if(i == m && j < n){
					matrix[i][j] = matrix[i][j+1] && (s2.charAt(j) == s3.charAt(i+j));
				}else if(i < m && j == n){
					matrix[i][j] = matrix[i+1][j] && (s1.charAt(i) == s3.charAt(i+j));
				}else{
					if(s1.charAt(i) == s3.charAt(i+j)){
						matrix[i][j] = matrix[i+1][j];
					}
					if(s2.charAt(j) == s3.charAt(i+j)){
						matrix[i][j] = matrix[i][j] || matrix[i][j+1];
					}
				}
			}
		}
		return matrix[0][0];
	}
	
	boolean checkCharCount(String s1, String s2, String s3){
		int[] count = new int[256];
		for(int i=0;i<s1.length();i++){
			char c = s1.charAt(i);
			count[c]++;
		}
		for(int i=0;i<s2.length();i++){
			char c = s2.charAt(i);
			count[c]++;
		}
		for(int i=0;i<s3.length();i++){
			char c = s3.charAt(i);
			count[c]--;
		}
		for(int i=0;i<256;i++){
			if(count[i] != 0){
				return false;
			}
		}
		return true;
	}
	
	//Use Backtrack to check if s3 is interleaving of s1 and s2
	//This will throw TLE error for large test data!
    public boolean isInterleave2(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length()+s2.length() != s3.length()){
            return false;
        }
        return check(s1, s2, s3, 0, 0);
    }
    
    boolean check(String s1, String s2, String s3, int i, int j){
        if(i == s1.length() && j == s2.length()){
            return true;
        }
        char c = s3.charAt(i+j);
        if(i < s1.length() && s1.charAt(i) == c
            && check(s1, s2, s3, i+1, j)){
            return true;
        }
        if(j < s2.length() && s2.charAt(j) == c
            && check(s1, s2, s3, i, j+1)){
            return true;
        }
        return false;
    }
}