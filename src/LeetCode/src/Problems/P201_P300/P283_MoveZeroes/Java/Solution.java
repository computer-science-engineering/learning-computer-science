package LeetCode.src.Problems.P201_P300.P283_MoveZeroes.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
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
}