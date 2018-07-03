package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.TwoSum.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{0, 0};
        for (int i=0; i<=nums.length-1; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = map.get(nums[i]);
                result[1] = i;
            } else {
                map.put(target - nums[i], i);                
            }
        }
        return result;
    }
}