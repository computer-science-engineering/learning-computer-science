package LeetCode.src.Explore.Interview.TopInterviewQuestions_Easy.Array.IntersectionOfTwoArrays2.Java;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int count = 0;
        int[] arr = new int[Math.min(nums1.length, nums2.length)];
        
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                arr[count] = i;
                map.replace(i, map.get(i)-1);
                count++;
            }
        }
        
        return Arrays.copyOf(arr, count);
    }
}