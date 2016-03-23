package other;

public class ValidNumber {
    public boolean isNumber(String s) {
        if(s==null||s.trim().length()==0) return false;
        s = s.trim();
        String[] a = s.split("e");
        if(a.length == 1){
            return isDouble(s);
        }else if(a.length == 2){
            return isDouble(a[0]) && isInteger(a[1]);
        } else {
            return false;
        }
    }

    boolean isInteger(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);
        if(s.length() == 0) return false;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c<'0' || c>'9') return false;
        }
        return true;
    }

    boolean isDouble(String s) {
        if(s.length() == 0) return false;
        if(s.charAt(0) == '+' || s.charAt(0) == '-') s = s.substring(1);

        String[] a = s.split("\\.");
        if(a.length == 1){
            return isInteger(a[0]);
        }else if(a.length == 2){
            String t = a[1];
            if(t.length() == 0 || t.charAt(0) < '0' || t.charAt(0) > '9'){
                return false;
            }
            return (a[0].length()==0 || isInteger(a[0])) && isInteger(a[1]);
        } else {
            return false;
        }
    }
}
