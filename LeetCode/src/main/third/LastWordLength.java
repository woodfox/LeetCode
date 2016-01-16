package third;

public class LastWordLength {
    public int lengthOfLastWord(String s) {
        if(s == null) return 0;

        String[] a = s.split(" ");
        if(a.length == 0) return 0;

        return a[a.length-1].length();
    }
}
