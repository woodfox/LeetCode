package third;

import java.util.ArrayList;
import java.util.List;

public class WildcardMatch {
    /**
     * dp(i,j) = dp(i-1,j-1) if s[i]==p[j] or p[j]= . or p[j] = *
     *        || dp(i-1, j) || dp(i, j-1) if p[j] = *
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                } else if(j==0){
                    dp[i][j] = false;
                } else if(i==0){
                    dp[i][j] = dp[i][j-1] && p.charAt(j-1) == '*';
                } else {
                    char c = s.charAt(i-1);
                    char d = p.charAt(j-1);
                    if(d=='*'){
                        dp[i][j] = dp[i][j-1] || dp[i-1][j];
                    }
                    if(c==d || d=='?' || d=='*'){
                        dp[i][j] = dp[i][j] || dp[i-1][j-1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public boolean isMatch_complex(String s, String p) {
        if(s == null || p == null) return false;

        return isMatchPattern(s, splitByStar(p));
    }

    private boolean isMatchPattern(String s, List<String> patterns){
        if(patterns.isEmpty()){
            return s.isEmpty();
        }else if(patterns.size() == 1 && "*".equals(patterns.get(0))){
            // it's still valid if pattern has only * left
            return true;
        }

        boolean fromStart = true;
        String subString = patterns.get(0);
        if("*".equals(subString)){
            fromStart = false;
            subString = patterns.get(1);

            // should match the last part of string. Eg, "abcabc" matches "*abc"
            if(patterns.size() == 2){
                int pos = Math.max(s.length() - subString.length(), 0);
                String t = s.substring(pos);
                return isMatchPattern(t, patterns.subList(1, 2));
            }
        }

        int n = subString.length();
        if(fromStart) {
            if(findPosition(s, 0, subString) == 0) {
                return isMatchPattern(s.substring(n), patterns.subList(1, patterns.size()));
            }else{
                return false;
            }
        }else{
            int pos = findPosition(s, 0, subString);
            if(pos >= 0)
                return isMatchPattern(s.substring(pos + n), patterns.subList(2, patterns.size()));
            else
                return false;
        }
    }

    // Separate pattern with * (multiple * would only save as one)
    private List<String> splitByStar(String p) {
        List<String> list = new ArrayList<String>();
        int start = 0;
        while(start < p.length()){
            if(p.charAt(start) == '*'){
                while(start < p.length() && p.charAt(start) == '*') start++;
                list.add("*");
            }else {
                int end = start + 1;
                while (end < p.length() && p.charAt(end) != '*') end++;
                list.add(p.substring(start, end));
                start = end;
            }
        }
        return list;
    }

    private int findPosition(String s, int start, String p){
        int m = s.length();
        int n = p.length();
        for(int i=start;i<=m-n;i++){
            int j=0;
            for(;j<n;j++){
                if(!isEqualOrAny(p, j, s, i+j)) break;
            }
            if(j >= p.length()) return i;
        }
        return -1;
    }

    private boolean isEqualOrAny(String p, int i, String s, int j){
        char a = p.charAt(i);
        char b = s.charAt(j);
        return a == '?' || a == b;
    }

    //---------------------------------------------------
    public boolean isMatch2(String s, String p) {
        if(s == null || p == null) return false;

        p = mergeStars(p);
        return backtrack(s, 0, p, 0);
    }

    private String mergeStars(String p) {
        StringBuffer sb = new StringBuffer();
        for(int pos = 0;pos<p.length();pos++){
            if(pos > 0 && p.charAt(pos-1) == p.charAt(pos) && p.charAt(pos) == '*')
                continue;

            sb.append(p.charAt(pos));
        }
        return sb.toString();
    }

    // Time Limit Exceeded!!
    // Use backtrack to simulate Turing Machine State
    private boolean backtrack(String s, int pos1, String p, int pos2) {
        int m = s.length();
        int n = p.length();
        if(pos1 >= m && pos2 >= n){
            return true;
        }else if(pos1 >= m || pos2 >= n){
            return false;
        }

        char a = s.charAt(pos1);
        char b = p.charAt(pos2);
        if(a == b || b == '?') {
            return backtrack(s, pos1+1, p, pos2+1);
        }else if(b == '*'){
            return backtrack(s, pos1+1, p, pos2) || backtrack(s, pos1, p, pos2+1) || backtrack(s, pos1+1, p, pos2+1);
        }

        return false;
    }

    // Memory Limit Exceeded using DP
    public boolean isMatch3(String s, String p) {
        if(s == null || p == null) return false;

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i ==0 && j == 0){
                    dp[i][j] = true;
                }else if(i > 0 && j == 0){
                    dp[i][j] = false;
                }else if(i == 0 && j > 0){
                    dp[i][j] = isStar(p, j-1) && dp[i][j-1];
                }else{
                    dp[i][j] = isEqual(s, i-1, p, j-1) && dp[i-1][j-1];
                    //DANGER: should consider if s remove one character or p remove one character, or both!
                    dp[i][j] = dp[i][j] || (isStar(p, j-1) && (dp[i-1][j-1] || dp[i-1][j] || dp[i][j-1]));
                    dp[i][j] = dp[i][j] || (isQuestion(p, j-1) && dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    private boolean isEqual(String s, int pos1, String p, int pos2){
        return s.charAt(pos1) == p.charAt(pos2);
    }

    private boolean isQuestion(String p, int pos){
        return p.charAt(pos) == '?';
    }

    private boolean isStar(String p, int pos) {
        return p.charAt(pos) == '*';
    }
}
