package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P1_MaximumSumSubarrayOfSizeK.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
        System.out.println("Maximum sum of a subarray of size K: "
                + findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}));
    }

    /*
     * Time Complexity The time complexity of the is O(N). Space Complexity The algorithm runs in
     * constant space O(1).
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = -1;
        int windowStart = 0;
        int windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return maxSum;
    }

    /*
     * The time complexity is O(N∗K), where 'N' is the total number of elements in the given array.
     */
    public static int findMaxSumSubArray_naive(int k, int[] arr) {
        int maxSum = 0, windowSum;
        for (int i = 0; i <= arr.length - k; i++) {
            windowSum = 0;
            for (int j = i; j < i + k; j++) {
                windowSum += arr[j];
            }
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
