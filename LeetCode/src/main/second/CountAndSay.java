package second;

public class CountAndSay {
    public String countAndSay(int n) {
        String x = "1";
        if(n <= 0){
            return x;
        }
        
        for(int i=2;i<=n;i++){
            x = count(x);
        }
        return x;
    }
    
    String count(String s){
        int n = s.length();
        int i = 0;
        StringBuffer sb = new StringBuffer();
        while(i < n){
            char c = s.charAt(i);
            int count = 1;
            i++;
            while(i<n && s.charAt(i) == c){
                i++;
                count++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sb.toString();
    }
}
