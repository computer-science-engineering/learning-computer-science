package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.MaxConsecutiveOnes2.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, q = -1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0) {
                l = q + 1;
                q = h;
            }
            max = Math.max(max, h - l + 1);
        }
        return max;
    }
}