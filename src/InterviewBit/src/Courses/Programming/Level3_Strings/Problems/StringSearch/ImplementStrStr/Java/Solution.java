package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringSearch.ImplementStrStr.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(strStr("test", "es"));
    }    

    public static int strStr(final String A, final String B) { // A - haystack; B - needle
        if (A == null && B == null) {
            return -1;
        }
        if (A == null) {
            return -1;
        }
        if (B == null) {
            return -1;
        }

        for (int i = 0; i < A.length() - B.length() + 1; i++) {
            int j = 0;
            for (; j < B.length(); j++) {
                if (A.charAt(i+j) != B.charAt(j)) {
                    break;
                }
            }
            if (j == B.length()) {
                return i;
            }
        }

        return -1;
    }
}