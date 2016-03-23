package other;

public class WubiEncode {
    public int encodeIndex(String s) {
        if(s.length() == 0) return -1;

        char c = s.charAt(0);
        int total = (25*25*25 + 3)*(c-'a');
        if(s.length() < 4) {
            return total + s.length() - 1;
        } else {
            int sub = 0;
            for(int i=1;i<4;i++){
                int p = s.charAt(i) - 'a';
                sub = sub*25 + p;
            }
            return total + sub + 3;
        }
    }

    public String encodeString(int n) {
        StringBuffer sb = new StringBuffer();
        int base = 25*25*25 + 3;
        int x = n/base;
        sb.append((char)('a' + x));

        n = n%base;
        if(n==0) {
        } else if(n==1){
            sb.append('a');
        } else if(n==2){
            sb.append("aa");
        } else {
            n = n-3;
            for(int i=0;i<3;i++){
                int p = n%25;
                sb.insert(1, (char)('a' + p));
                n = n/25;
            }
        }

        return sb.toString();
    }
}