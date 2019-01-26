package LeetCode.src.Problems.P1_P100.P28_ImplementStrStr.Java;

public class Solution {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null && needle == null) {
            return -1;
        }
        if (haystack == null) {
            return -1;
        }
        if (needle == null) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break; // breaks inner for loop
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}