package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.PlusOne.Java;

public class Solution {
    public static void main(String[] args) {
        int[] digits = {4,3,2,9};
        int[] result = plusOne(digits);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i] = (digits[i]+1)%10;
            if((digits[i]) == 0){
                continue;
            }
            return digits;
        }

        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}