package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringSimulation.LongestCommonPrefix;

public class Solution {
    public static void main(String[] args) {
        //String[] input = new String[] {"abcdefgh", "aefghijk", "abcefgh"};       
        String[] input = new String[] {"ABCD"};
        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] A) {
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < A.length; i++){
            if(minLen > A[i].length())
                minLen = A[i].length();
        }
        
        if(minLen == 0) {
            return "";
        }

        for(int j = 0; j < minLen; j++){
            char prev = '0';
            for(int i = 0; i < A.length; i++){
                if(i == 0) {
                    prev = A[i].charAt(j);
                    continue;
                }
                if(A[i].charAt(j) != prev) {
                    return A[i].substring(0, j);
                }
            }
        }
        return A[0].substring(0, minLen);
    }
}