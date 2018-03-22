package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q1_IsUnique.Java;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars_solution1(word));
        }

        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars_solution2(word));
        }
    }

    public static boolean isUniqueChars_solution1(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /* Assumes only letters a through z. */
    public static boolean isUniqueChars_solution2(String str) {
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
}
