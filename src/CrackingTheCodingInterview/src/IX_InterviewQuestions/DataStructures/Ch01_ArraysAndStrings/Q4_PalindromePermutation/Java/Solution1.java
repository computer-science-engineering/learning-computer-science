package CrackingTheCodingInterview.src.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q4_PalindromePermutation.Java;

public class Solution1 {
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = Common.buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static void main(String[] args) {
        String palindrome = "Rats live on no evil star";
        System.out.println(isPermutationOfPalindrome(palindrome));
    }
}
