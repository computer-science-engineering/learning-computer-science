package LeetCode.src.Problems.P601_P700.P698_PartitionToKEqualSumSubsets.Java;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = IntStream.of(nums).sum();
        return k != 0 && sum % k == 0 && canPartition(0, nums, new boolean[nums.length], k, 0, sum / k);
    }

    private static boolean canPartition(int start, int[] a, boolean[] seen, int k, int sum, int target) {
        if (k == 1) {
            return true;
        }
        if (sum == target) {
            return canPartition(0, a, seen, k - 1, 0, target);
        }
        for (int i = start; i < a.length; i++) {
            if (!seen[i]) {
                seen[i] = true;
                if (canPartition(i + 1, a, seen, k, sum + a[i], target)) {
                    return true;
                }
                seen[i] = false;
            }
        }
        return false;
    }
}