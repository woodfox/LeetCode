package third;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An abbreviation of a word follows the form . Below are some examples of word abbreviations:

 a) it --> it (no abbreviation)
 b) d|o|g --> d1g
 c) i|nternationalizatio|n --> i18n
 d) l|ocalizatio|n --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:

 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 */
public class UniqueWordAbbreviation {
    Set<String> set = new HashSet();
    public UniqueWordAbbreviation(List<String> dict) {
        for(String s : dict) {
            set.add(abbrev(s));
        }
    }

    private String abbrev(String s) {
        if(s.length() <= 2) {
            return s;
        } else {
            int n = s.length();
            return "" + s.charAt(0) + (n-2) + s.charAt(n-1);
        }
    }

    public boolean isUnique(String s) {
        return !set.contains(abbrev(s));
    }
}
