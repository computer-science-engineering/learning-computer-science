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
        int n = nums.length, low = 0, hi = nums[n-1] - nums[0];
        while (low < hi) {
            int cnt = 0, j = 0, mid = (low + hi)/2;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[j] - nums[i] <= mid) {
                    ++j;
                }
                cnt += j - i-1;
            }
            if (cnt >= k) {
                hi = mid;
            }            
            else {
                low = mid + 1;
            }
        }
        
        return low;
    }
}