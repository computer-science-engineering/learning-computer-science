package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.SingleNumber.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int retVal = 0;
        for (int i : nums ) {
            retVal = retVal ^ i;
        }
        return retVal;
    }
}