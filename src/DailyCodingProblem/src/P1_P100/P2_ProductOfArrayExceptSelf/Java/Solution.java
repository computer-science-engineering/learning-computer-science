package DailyCodingProblem.src.P1_P100.P2_ProductOfArrayExceptSelf.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = productExceptSelf(nums);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
     
        result[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--) {
            result[i] = result[i+1]*nums[i+1];
        }
     
        int left=1;
        for(int i=0; i<nums.length; i++) {
            result[i] = result[i]*left;
            left = left*nums[i];
        }
     
        return result;
    }
}