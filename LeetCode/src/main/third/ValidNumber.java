package third;

public class ValidNumber {
    //Danger: Split by "e", and check left and right differently (right doesn't allow decimal)
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;

        s = s.trim();
        int pos = s.indexOf("e");
        if(pos == 0 || pos == s.length()-1){
            return false;
        }
        else if(pos > -1) {
            return isValid(s.substring(0, pos), true) && isValid(s.substring(pos+1), false);
        }else{
            return isValid(s, true);
        }
    }

    boolean isValid(String s, boolean allowDecimal) {
        if(s.length() == 0) return false;

        char c = s.charAt(0);
        if(c == '+' || c == '-') s = s.substring(1);

        int decimalCount = 0;
        int numberCount = 0;
        for(char d : s.toCharArray()) {
            if(d == '.') {
                decimalCount++;
            }else if(d < '0' || d > '9'){
                return false;
            }else{
                numberCount++;
            }
        }

        if(!allowDecimal){
            return numberCount > 0 && decimalCount == 0;
        }else {
            return numberCount > 0 && decimalCount < 2;
        }
    }
}
