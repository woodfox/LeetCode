package third;

public class RegularExpressionMatch {
    /**           | true               if i == 0, j == 0
     *            | false              else if j == 0
     * f(i, j) =  | p[j-1].isStar && f[i][j-1]      else if i == 0
     * i = 0 .. m | (isEqual(s[i-1], p[j-1]) && (f[i-1][j-1]) || (p[j-1].isStar && f[i-1][j])) || (p[j-1].isStar && f[i][j-1]))
     * j = 0 .. n |                    else
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;

        String t = p.replaceAll("\\*", "");
        int m = s.length();
        int n = t.length();

        boolean[] stars = new boolean[n];
        int pos = 1;
        for(int i=0;i<n;i++){
            if(pos < p.length() && p.charAt(pos) == '*'){
                stars[i] = true;
                pos++;
            }
            pos++;
        }

        boolean[][] f = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i == 0 && j == 0){
                    f[i][j] = true;
                }else if(j == 0){
                    f[i][j] = false;
                }else if(i == 0){
                    f[i][j] = stars[j-1] && f[i][j-1];
                }else{
                    f[i][j] = isEqual(s.charAt(i-1), t.charAt(j-1)) && (f[i-1][j-1] || (stars[j-1] && f[i-1][j]));
                    f[i][j] = f[i][j] || (stars[j-1] && f[i][j-1]);
                }
            }
        }
        return f[m][n];
    }

    private boolean isEqual(char c, char p) {
        return c == p || p == '.';
    }
}
