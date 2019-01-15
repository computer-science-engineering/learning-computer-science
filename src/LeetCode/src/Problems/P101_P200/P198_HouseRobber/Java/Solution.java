package LeetCode.src.Problems.P101_P200.P198_HouseRobber.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob_opt(nums));
    }

    public static int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    /*
    f(k) = Largest amount that you can rob from the first k houses.
    Ai = Amount of money at the ith house.
    f(k) = max(f(k – 2) + Ak, f(k – 1))
    */
    public static int rob_opt(int[] nums) {
        int prevMax = 0; // k-2
        int currMax = 0; // k-1
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax); // newCurrMax = max( f(k-2)+Ak, f(k-1))
            prevMax = temp;
        }
        return currMax;
    }
}