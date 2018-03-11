package CrackingTheCodingInterview.src.Book.IX_InterviewQuestions.DataStructures.Ch01_ArraysAndStrings.Q4_PalindromePermutation.Java;

public class Solution2 {
    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    public static void main(String[] args) {
        String palindrome = "Ratzs live on no evil starz";
        System.out.println(isPermutationOfPalindrome(palindrome));
        String palindrome2 = "Zeus was deified, saw Suez";
        System.out.println(isPermutationOfPalindrome(palindrome2));
    }
}
