package third;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> result = new ArrayList<String>();
        int pos = 0;
        while(pos < words.length){
            ArrayList<String> list = new ArrayList<String>();
            int length = 0;
            while(pos < words.length){
                if(length + words[pos].length() + list.size() <= maxWidth){
                    list.add(words[pos]);
                    length += words[pos].length();
                    pos++;
                }else{
                    break;
                }
            }

            boolean lastLine = pos >= words.length;
            result.add(generateLine(list, maxWidth - length, lastLine));
        }

        return result;
    }

    private String generateLine(ArrayList<String> words, int spaces, boolean lastLine) {
        if(words.size() == 0) return "";

        ArrayList<Integer> spaceNumbers = calculateSpaces(words.size(), spaces, lastLine);
        StringBuffer sb = new StringBuffer();
        for(int pos=0;pos < words.size();pos++){
            sb.append(words.get(pos));
            appendSpaces(sb, spaceNumbers.get(pos));
        }

        return sb.toString();
    }

    private ArrayList<Integer> calculateSpaces(int size, int spaces, boolean lastLine) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(size == 1){
            // Only one word
            result.add(spaces);
        }else{
            // Calculate spaces between words
            int average = spaces/(size-1);
            int extra = spaces%(size-1);
            for(int pos=0;pos<size-1;pos++){
                if(lastLine){
                    result.add(1);
                }else if(pos < extra){
                    result.add(average + 1);
                }else{
                    result.add(average);
                }
            }

            // Calculate spaces after last word
            if(lastLine){
                result.add(spaces-result.size());
            }else{
                result.add(0);
            }
        }

        return result;
    }

    private void appendSpaces(StringBuffer sb, int spaces) {
        for(int i=0;i<spaces;i++){
            sb.append(" ");
        }
    }
}
