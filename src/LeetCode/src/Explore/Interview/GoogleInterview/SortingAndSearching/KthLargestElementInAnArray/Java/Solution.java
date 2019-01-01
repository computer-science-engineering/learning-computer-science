package LeetCode.src.Explore.Interview.GoogleInterview.SortingAndSearching.KthLargestElementInAnArray.Java;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int start = 0, end = nums.length - 1, index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < index) start = pivot + 1;
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = start;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            exch(nums, start, end);
        }
        exch(nums, pivot, end);
        return end;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }
}