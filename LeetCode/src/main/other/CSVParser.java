package other;

/**
 * For this problem, there are several cases need to consider:
 1. For comma, transform to |
 2. If comma is inside a quote, don't treat the comma as separated. Remove the comma and print the entire token. e.g. "San Francisco, CA" => San Francisco, CA
 3. If there are double quotes, remove one. e.g. "Alexandra ""Alex""" => Alexandra "Alex".
 Note that """Alexandra Alex""" becomes "Alexandra Alex" because we first remove the outer-most quote, and then remove one quote of the double quote.
 */
public class CSVParser {
    public String parse(String s) {
        int n = s.length();
        if(n==0) return s;

        StringBuffer sb = new StringBuffer();
        int start = 0;
        int end = 0;
        while(end<n){
            int count = 0;
            while(end<n){
                char c = s.charAt(end);
                if(c == '"'){
                    if(end+1<n && s.charAt(end+1) == '"'){
                        end++;
                    } else if(count > 0) {
                        count--;
                    } else {
                        count++;
                    }
                    end++;
                } else if(c == ','){
                    if(count == 0) break;

                    end++;
                } else {
                    end++;
                }
            }

            String t = s.substring(start, end);
            if(t.startsWith("\"") && t.endsWith("\"")) {
                t = t.substring(1, t.length()-1);
            }
            t = t.replaceAll("\"\"", "\"");
            sb.append("|" + t);

            end++;
            start = end;
        }

        return sb.substring(1);
    }
}
