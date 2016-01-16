package first;
public class EditDistance {
	public int minDistance(String s, String t) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int m = s.length();
	        int n = t.length();
	        int[][] f = new int[m+1][n+1];
	        for(int i=0;i<=m;i++){
	            for(int j=0;j<=n;j++){
	                if(i == 0 && j == 0){
	                    f[i][j] = 0;
	                }else if(i == 0){
	                    f[i][j] = f[i][j-1] + 1;
	                }else if(j == 0){
	                    f[i][j] = f[i-1][j] + 1;
	                }else{
	                    int min = Math.min(f[i-1][j] +1, f[i][j-1] + 1);
	                    int c = 0;
	                    if(s.charAt(i-1) != t.charAt(j-1)){
	                        c = 1;
	                    }
	                    min = Math.min(min, f[i-1][j-1] + c);
	                    f[i][j] = min;
	                }
	            }
	        }
	        return f[m][n];
	    }
}
