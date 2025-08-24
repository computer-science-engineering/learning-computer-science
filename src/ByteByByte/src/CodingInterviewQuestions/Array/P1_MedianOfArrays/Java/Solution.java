package ByteByByte.src.CodingInterviewQuestions.Array.P1_MedianOfArrays.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input1 = {1, 3, 8, 9, 15};
        int[] input2 = {7, 11, 19, 21, 18, 25};
        System.out.println(findMedianSortedArrays(input1, input2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int k = (len1 + len2 + 1) / 2;
        int l = 0;
        int r = len1;
        //find the m1 so that nums1[m1] >= nums2[m2 - 1]
        while(l < r){
            int nums1ArrayIndex = l + (r - l) / 2;
            int nums2ArrayIndex = k - nums1ArrayIndex;
            if (nums1[nums1ArrayIndex] < nums2[nums2ArrayIndex - 1]) {
                l = nums1ArrayIndex + 1;
            } else {
                r = nums1ArrayIndex;
            }
        }
        int nums1ArrayIndex = l;
        int nums2ArrayIndex = k - l;
        int c1 = Math.max(nums1ArrayIndex <= 0 ? Integer.MIN_VALUE : nums1[nums1ArrayIndex - 1],
                nums2ArrayIndex <= 0? Integer.MIN_VALUE: nums2[nums2ArrayIndex - 1]);
        if ((len1 + len2) % 2 ==1) return c1;
        int c2 = Math.min(nums1ArrayIndex >= len1 ? Integer.MAX_VALUE : nums1[nums1ArrayIndex],
                nums2ArrayIndex >= len2 ? Integer.MAX_VALUE: nums2[nums2ArrayIndex]);
        return (c1 + c2) / 2.0;
    }
}