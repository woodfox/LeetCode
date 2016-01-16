package second;

public class ValidNumber {
	public boolean isNumber(String s) {
        if(s == null){
            return false;
        }
        
        s = s.trim();
        if(s.length() == 0 || s.startsWith("e") || s.endsWith("e")){
            return false;
        }
        
        String[] a = s.split("e");
        if(a.length > 2){
            return false;
        }else if(a.length == 2){
            return validate(a[0], true) && validate(a[1], false);
        }else{
            return validate(s, true);
        }
    }
    
    boolean validate(String s, boolean decimalFlag){
        if(s == null || s.length() == 0){
            return false;
        }
        char c = s.charAt(0);
        if(c == '+' || c == '-'){
            s = s.substring(1);
            if(s.length() == 0){
                return false;
            }
        }
        
        int count = 0;
        int numbers = 0;
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(c == '.'){
                count++;
                if(!decimalFlag || count > 1){
                    return false;
                }
            }else if(c < '0' || c > '9'){
                return false;
            }else{
                numbers++;
            }
        }
        if(numbers > 0){
            return true;
        }else{
            return false;
        }
    }
}
