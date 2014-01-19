package second;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s == null || t == null 
          || s.length() == 0 || t.length() == 0){
            return "";
        }
        
        int m = s.length();
        int n = t.length();
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        for(int i=0;i<n;i++){
            count1[t.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        while(j < m){
            count2[s.charAt(j)]++;
            if(containAll(count1, count2)){
                break;
            }
            j++;
        }
        String min = "";
        while(j < m){
            if(min.length() == 0 || min.length() > j-i+1){
                min = s.substring(i, j+1);
            }
            char c = s.charAt(i);
            count2[c]--;
            i++;
            if(count2[c] < count1[c]){
                j++;
                while(j < m){
                    char d = s.charAt(j);
                    count2[d]++;
                    if(d == c){
                        break;
                    }
                    j++;
                }
            }
        }
        
        return min;
    }
    
    boolean containAll(int[] count1, int[] count2){
        for(int i=0;i<count1.length;i++){
            if(count2[i] < count1[i]){
                return false;
            }
        }
        return true;
    }
}
