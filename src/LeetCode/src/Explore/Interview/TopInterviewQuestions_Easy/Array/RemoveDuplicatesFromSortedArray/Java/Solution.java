package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.RemoveDuplicatesFromSortedArray.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums  = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lastUniqueNum = nums[0];
        int nextUniquePos = 1;
        for (int n : nums) {
            if (n > lastUniqueNum) {
                lastUniqueNum = n;
                nums[nextUniquePos++] = n;
            }
        }
        return nextUniquePos;
    }
}