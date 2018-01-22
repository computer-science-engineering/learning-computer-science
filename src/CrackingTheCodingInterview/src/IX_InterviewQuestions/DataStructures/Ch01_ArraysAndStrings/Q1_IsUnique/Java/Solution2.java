package CrackingTheCodingInterview.src.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q1_IsUnique.Java;

public class Solution2 {
    /* Assumes only letters a through z. */
    public static boolean isUniqueChars(String str) {
        // Only 26 characters
        if (str.length() > 26) return false;
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
