package first;
public class MinCut {
	//Dijkstra with O(n^2)?
	public int minCut(String s){
		return 0;
	}
	
	//Min cut with O(n^3) which has Time Limited Exception
	public int minCut2(String s){		
		int m = s.length();
		int[][] matrix = new int[m][m];
		for(int k=0;k<=m-1;k++){
			for(int i=0;i<=m-1-k;i++){
				int j = i+k;
				String t = s.substring(i, j+1);
				if(k == 0 || t.equals(reverse(t))){
					matrix[i][j] = 0;
				}else {
					int min = Integer.MAX_VALUE;
					for(int x=i+1;x<=j;x++){
						if(min > matrix[i][x-1] + matrix[x][j] + 1){
							min = matrix[i][x-1] + matrix[x][j] + 1;
						}
					}
					matrix[i][j] = min;
				}
			}
		}
		
		return matrix[0][m-1];
	}
	
	public String reverse(String s){
		StringBuffer sb = new StringBuffer();
		for(int i=s.length()-1;i>=0;i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
	
//	public int[] getLCS(String s, String t){
//		int m = s.length();
//		int n = t.length();
//		int[][] c = new int[m+1][n+1];
//		for(int i=0;i<=n;i++){
//			c[0][i] = 0;
//		}
//		for(int i=0;i<=m;i++){
//			c[i][0] = 0;
//		}
//		
//		for(int i=1;i<=m;i++){
//			for(int j=1;j<=n;j++){
//				if(s.charAt(i-1) == t.charAt(j-1)){
//					c[i][j] = c[i-1][j-1] + 1;
//				}else {
//					c[i][j] = 0;
//				}
//			}
//		}
//		
//		int max = 0;
//		int end = 0;
//		for(int i=m;i>=0;i--){
//			for(int j=n;j>=0;j--){
//				if(max < c[i][j]){
//					int xStart = i - c[i][j] + 1;
//					int yStart = j - c[i][j] + 1;
//					//It has to be the reverse part of the same substring!!
//					if(xStart == m - j + 1 && yStart == n - i + 1){
//						max = c[i][j];
//						end = i;
//					}
//				}
//			}
//		}
//		
//		int start = end - max + 1;
//		int[] result = {start-1, end-1};
//		
//		return result;
//	}
	
//	int[] getLCSByKMP(String s, String t){
//		if(s.length() < t.length()){
//			return getLCSByKMP(t, s);
//		}
//		int m = s.length();
//		int n = t.length();
//		int max =0;
//		int end = 0;
//		for(int i=0;i<n;i++){
//			String x = t.substring(i, n);
//			int[] p = computePrefix(x);
//			
//			int q = 0;
//			for(int j=0;j<m;j++){
//				while(q > 0 && x.charAt(q) != s.charAt(j)){
//					q = p[q];
//				}
//				if(x.charAt(q) == s.charAt(j)){
//					q++;
//				}
//				if(max < q && i == (m-j) && (n-i-max) == j-max+1){
//					max = q;
//					end = j;
//				}
//				if(q == x.length()){
//					break;
//				}
//			}
//		}
//		int[] r = {end-max+1, end};
//		return r;
//	}
//	
//	private int[] computePrefix(String s) {
//		int m = s.length();
//		int[] p = new int[m];
//		p[0] = 0;
//		int k = 0;
//		for(int q=1;q<m;q++){
//			while(k>0 && s.charAt(k)!=s.charAt(q)){
//				k = p[k-1];
//			}
//			if(s.charAt(k) == s.charAt(q)){
//				k++;
//			}
//			p[q] = k;
//		}
//		return p;
//	}

	public static void main(String[] args){	
		MinCut m = new MinCut();
		System.out.println("a 0:" + m.minCut("a"));
		System.out.println("aabbaa 0:" + m.minCut("aabbaa"));
		System.out.println("aabb 1:" + m.minCut("aabb"));
		System.out.println("abab 1:" + m.minCut("abab"));
		System.out.println("abacdc 1:" + m.minCut("abacdc"));
		System.out.println("xabcdcby 3:" + m.minCut("xabcdcby"));
		System.out.println("abadadab 1:" + m.minCut("abadadab"));
		System.out.println("\nadabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece 42:" 
				+ m.minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"));
		
		System.out.println("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp:"
				+ m.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
	}
}
