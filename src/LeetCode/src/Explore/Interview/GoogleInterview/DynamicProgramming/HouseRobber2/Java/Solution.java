package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.HouseRobber2.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

     /*
    f(k) = Largest amount that you can rob from the first k houses.
    Ai = Amount of money at the ith house.
    f(k) = max(f(k – 2) + Ak, f(k – 1))
    */
    private static int rob(int[] nums, int lo, int hi) {
        int prevMax = 0; // k-2
        int currMax = 0; // k-1
        for (int j = lo; j <= hi; j++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[j], currMax); // newCurrMax = max( f(k-2)+Ak, f(k-1))
            prevMax = temp;
        }
        return currMax;
    }
}