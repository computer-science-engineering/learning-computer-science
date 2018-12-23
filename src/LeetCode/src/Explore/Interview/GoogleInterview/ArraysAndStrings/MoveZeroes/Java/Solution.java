package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.MoveZeroes.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }    

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}