package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringTricks.LongestPalindromicSubstring;

public class Solution {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabaaa"));
    }
    
    public static String longestPalindrome(String A) {
        int maxLength = 1; // length of LPS
        
        int start = 0;
        int len = A.length();

        int low, high;

        // One by one consider every character as center
        // point of even and odd length palindromes
        for (int i = 1; i < len; ++i) 
        {
            // Find the longest even length palindrome with 
            // center points as i-1 and i.
            low = i - 1;
            high = i;
            while (low >= 0 && high < len && A.charAt(low) == A.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }

            // Find the longest odd length palindrome with 
            // center point as i.
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < len && A.charAt(low) == A.charAt(high)) {
                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }
                --low;
                ++high;
            }
        }

        return A.substring(start, start+maxLength);
    }
}