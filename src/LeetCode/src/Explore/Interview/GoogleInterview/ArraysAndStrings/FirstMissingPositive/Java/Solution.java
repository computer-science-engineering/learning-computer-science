package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.FirstMissingPositive.Java;
import LeetCode.src.SwapNumbersInArray;

public class Solution extends SwapNumbersInArray {
    public static void main(String[] args) {
        int[] input = {3, 4, -1, 1};
        int result = findMissingPositive(input);
        System.out.println(result);
    }

    public static int findMissingPositive(int[] nums) { 
        int i = 0, n = nums.length;
        while (i < n) {
            // If the current value is in the range of (0,length) and it's not at its correct position, 
            // swap it to its correct position.
            // Else just continue;
            if (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
            else {
                i++;
            }
        }
        int k = 1;

        // Check from k=1 to see whether each index and value can be corresponding.
        while (k < n && nums[k] == k) {
            k++;
        }

        // If it breaks because of empty array or reaching the end. K must be the first missing number.
        if (n == 0 || k < n) {
            return k;
        }
        else { // If k is hiding at position 0, K+1 is the number.
            return nums[0] == k ? k + 1 : k;
        }

    }

}