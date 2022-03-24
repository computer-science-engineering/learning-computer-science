package LeetCode.src.Problems.P1_P100.P31_NextPermutation.Java;

import static LeetCode.src.SwapNumbersInArray.swap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int item : nums) {            
            System.out.print(item + " ");
        }
    }

    public static void nextPermutation(int[] nums) {
        int leftBoundaryIndex = -1;
        for(int i=nums.length-1; i>0; i--) {
            if (nums[i-1] < nums[i]) {
                leftBoundaryIndex = i-1;
                break;
            }
        }

        if (leftBoundaryIndex>=0) {
            int j=nums.length-1;
            while(j>0 && nums[leftBoundaryIndex] >= nums[j]) {
                j--;
            }
            swap(nums, leftBoundaryIndex, j);
        }
        
        reverse(nums, leftBoundaryIndex+1);
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length-1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

//    private static void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
}