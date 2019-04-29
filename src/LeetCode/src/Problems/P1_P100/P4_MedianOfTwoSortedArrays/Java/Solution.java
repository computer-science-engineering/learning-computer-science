package LeetCode.src.Problems.P1_P100.P4_MedianOfTwoSortedArrays.Java;

public class Solution {
    public static void main(String[] args) {
        //int[] nums1 = {1, 3, 8, 9, 15};
        //int[] nums2 = {7, 11, 19, 21, 18, 25};
        int[] nums1 = {1,2,3,5,6};
        int[] nums2 = {4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    // https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481/Share-my-O(log(min(mn))-solution-with-explanation/246245
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int k = (len1 + len2 + 1) / 2;
        int l = 0;
        int r = len1;
        //find the m1 so that nums1[m1] >= nums2[m2 - 1]
        while(l < r){
            int m1 = l + (r - l) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1]){
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        int m1 = l;
        int m2 = k - l;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                         m2 <= 0? Integer.MIN_VALUE: nums2[m2 - 1]);
        if ((len1 + len2) % 2 ==1) return c1;
        int c2 = Math.min(m1 >= len1 ? Integer.MAX_VALUE : nums1[m1],
                         m2 >= len2 ? Integer.MAX_VALUE: nums2[m2]);
        return (c1 + c2) / 2.0;
    }

    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            findMedianSortedArrays1(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        if (x == 0) {
            return getMedian(nums2, y);
        }

        if (y == 0) {
            return getMedian(nums1, x);
        }

        int low = 0;
        int high = x;
        while(low <= high) {
            int partition_X = (low + high)/2;
            int partition_Y = (x + y + 1)/2 -  partition_X;

            int maxLeft_X = (partition_X <= 0) ? Integer.MIN_VALUE : nums1[partition_X - 1];
            int minRight_X = (partition_X == x) ? Integer.MAX_VALUE : nums1[partition_X];

            int maxLeft_Y = (partition_Y <= 0) ? Integer.MIN_VALUE : nums2[partition_Y - 1];
            int minRight_Y = (partition_Y == y) ? Integer.MAX_VALUE : nums2[partition_Y];

            if (maxLeft_X <= minRight_Y && maxLeft_Y <= minRight_X) {
                if ((x + y) % 2 == 0) {
                    return (double)(Math.max(maxLeft_X, maxLeft_Y) + Math.min(minRight_X, minRight_Y))/2;
                } else {
                    return (double)Math.max(maxLeft_X, maxLeft_Y);
                }
            } else if (maxLeft_X > minRight_Y) { // we are too far on right side for partition_X. Go on left side.
                high = partition_X - 1;
            } else { // we are too far on left side for partition_X. Go on right side.
                low = partition_X + 1;
            }
        }        

        // Input arrays were not sorted.
        throw new IllegalArgumentException();
    }

    private static double getMedian(int[] nums, int len) {
        if (len % 2 == 0) {
            return (double)(nums[(len+1)/2] + nums[(len-1)/2])/2;
        } else {
            return nums[len/2];
        }
    }
}