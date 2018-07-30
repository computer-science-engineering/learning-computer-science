package LeetCode.src.Problems.P198_HouseRobber.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public static int rob_opt(int[] nums) {
        int currentNo = 0;
        int currentYes = 0;
        for (int n : nums) {
            int temp = currentNo;
            currentNo = Math.max(currentNo, currentYes);
            currentYes = n + temp;
        }
        return Math.max(currentNo, currentYes);
    }
}