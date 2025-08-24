package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.ReadNCharactersGivenRead4.Java;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    public static void main(String[] args) {
        char[] buf = new char[10];
        int n = 8;

        Solution solution = new Solution();
        System.out.println(solution.read(buf, n));
    }
}