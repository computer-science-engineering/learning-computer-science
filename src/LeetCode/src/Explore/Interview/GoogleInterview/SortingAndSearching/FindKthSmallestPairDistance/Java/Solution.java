package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.FindKthSmallestPairDistance.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,3,1};
        int k = 1;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0;
        int hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int left = 0;
            int count = 0;
            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) left++;
                count += (right - left);
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}