package first;
public class DecodeWays {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int[] m =  new int[n+1];
        m[n] = 1;
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if(c == '0'){
                m[i] = 0;
            }else {
                m[i] = m[i+1];
                if(i <= n-2){
                    String t = s.substring(i, i+2);
                    if(Integer.parseInt(t) <= 26){
                        m[i] += m[i+2];
                    }
                }
            }
        }
        return m[0];
    }
}
