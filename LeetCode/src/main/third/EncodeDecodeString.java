package third;

import java.util.ArrayList;
import java.util.List;

/**Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

 Machine 1 (sender) has the function:

 string encode(vector<string> strs) {
 // ... your code
 return encoded_string;
 }
 Machine 2 (receiver) has the function:
 vector<string> decode(string s) {
 //... your code
 return strs;
 }
 So Machine 1 does:

 string encoded_string = encode(strs);
 and Machine 2 does:

 vector<string> strs2 = decode(encoded_string);
 strs2 in Machine 2 should be the same as strs in Machine 1.

 Implement the encode and decode methods.

 Note:
 The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
*/

public class EncodeDecodeString {
    /**
     * It's easier to use length and separator at the begining instead of at the end.
     */
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s : strs) {
            sb.append(s.length() + "#");
            sb.append(s);
        }
        return sb.toString();
    }
    public List<String> decode(String s) {
        int p = 0;
        List<String> r = new ArrayList();
        while(p < s.length()) {
            int q = s.indexOf("#", p);
            int len = Integer.parseInt(s.substring(p, q));
            r.add(s.substring(q+1, q+len+1));
            p = q+len+1;
        }
        return r;
    }

    /**
     * Encode with special separator between strings.
     */
    public String encode_slow(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s : strs) {
            sb.append(s);
            sb.append("#" + s.length() + "#");
        }
        return sb.toString();
    }

    public List<String> decode_slow(String s) {
        List<String> r = new ArrayList();
        int start = 0;
        // Starting position to find next #, may not be same as start
        int p = 0;
        while(p < s.length()) {
            int i = s.indexOf("#", p);
            int j = s.indexOf("#", i+1);

            // Calculate the length between ##
            int len = 0;
            for(int k=i+1;k<j;k++) {
                char c = s.charAt(k);
                if(c < '0' || c > '9') {
                    len = -1;
                    break;
                }
                len = len*10 + (c - '0');
            }

            if(j-i > 1 && len == i-start) {
                r.add(s.substring(start, i));
                start = j+1;
                p = j+1;
            } else {
                p = i+1;
            }
        }

        return r;
    }
}
