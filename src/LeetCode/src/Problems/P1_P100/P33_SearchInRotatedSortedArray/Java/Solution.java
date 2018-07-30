package LeetCode.src.Problems.P1_P100.P33_SearchInRotatedSortedArray.Java;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
        
            if (nums[start] <= nums[mid]) {
                 if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                 }
                 else {
                    start = mid + 1;
                 }
            }  else if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}