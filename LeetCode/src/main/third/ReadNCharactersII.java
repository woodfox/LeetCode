package third;

import scala.Array;

/**
 * The API

 int read4(char *buf)

 reads 4 characters at a time from a file. The return value is the actual number of characters read.
 For example, it returns 3 if there is only 3 characters left in the file. By using the read4 API,
 implement the function int read(char *buf, int n) that reads n characters from the file.

 Note
 The read function will only be called once for each test case.
 */
public class ReadNCharactersII extends Reader4 {
    private char[] remainBuffer = new char[4];
    private int remainSize = 0;

    public int read(char[] buf, int n) {
        char[] tmp = new char[4];
        boolean isEnd = false;
        int total = 0;

        if(remainSize > 0) {
            Array.copy(remainBuffer, 0, buf, 0, remainSize);
            total += remainSize;
            remainSize = 0;
        }

        while(isEnd && total < n) {
            int size = read4(tmp);
            isEnd = (size < 4);
            int length = Math.min(size, n-total);
            Array.copy(tmp, 0, buf, total, length);
            total += length;

            if(length < size) {
                remainSize = size - length;
                Array.copy(tmp, length, remainBuffer, 0, remainSize);
            }
        }

        return total;
    }
}
