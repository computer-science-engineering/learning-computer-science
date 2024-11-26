package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.ReadNCharactersGivenRead4.Java;

public class Reader4 {
    int read4(char[] buf) {
        return 4;
    }


    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0; // bytes read so far

        while (readBytes < n && !endOfFile) {
            int currentReadBytes = read4(buffer);
            if (currentReadBytes != 4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, currentReadBytes);
            for (int i=0; i<length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }
}