package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.MoveZeroes.Java;

import static LeetCode.src.SwapNumbersInArray.swap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,0,3,12};
        moveZeroes2(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        
        int start = 0;
        while(start<len && nums[start++]!=0);
        
        int j = start;
        start--;
        
        for(;j<len;j++) {
            if(nums[j]!=0) {
                nums[start++] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt++, cur);
            }
        }
    }

//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}