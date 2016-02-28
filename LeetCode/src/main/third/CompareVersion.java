package third;

/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:
 */
public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version1.length() == 0
                || version2 == null || version2.length() == 0) {
            return -1;
        }

        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");

        int i = 0;
        while(i < array1.length || i < array2.length) {
            int subVersion1 = 0;
            if(i < array1.length) {
                subVersion1 = Integer.parseInt(array1[i]);
            }

            int subVersion2 = 0;
            if(i < array2.length) {
                subVersion2 = Integer.parseInt(array2[i]);
            }

            if(subVersion1 > subVersion2) {
                return 1;
            } else if(subVersion1 < subVersion2) {
                return -1;
            }

            i++;
        }

        return 0;
    }
}
