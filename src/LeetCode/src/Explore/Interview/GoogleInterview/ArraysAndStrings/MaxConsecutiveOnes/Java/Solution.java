package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.MaxConsecutiveOnes.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0, running = 0;
        for(int i=0; i<=nums.length-1; i++) {
            if(nums[i] == 1) {
                running++;
            }
            else {
                result = Math.max(running, result);
                running = 0;
            }
        }
        return Math.max(running, result);
    }
}