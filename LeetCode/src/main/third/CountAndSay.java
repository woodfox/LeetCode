package third;

public class CountAndSay {
    public String countAndSay(int n) {
        return sayIt("1", n);
    }

    private String sayIt(String s, int n){
        if(n <= 1) return s;

        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(pos < s.length()){
            char c = s.charAt(pos);
            int count = 1;
            pos++;
            while(pos < s.length() && s.charAt(pos) == c){
                pos++;
                count++;
            }
            sb.append(count);
            sb.append(c);
        }
        return sayIt(sb.toString(), n-1);
    }
}
