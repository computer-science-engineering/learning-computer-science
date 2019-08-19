package EducativeIo.GrokkingTheCodingInterview.Ch06_CyclicSort.P4_FindTheDuplicateNumber.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findNumber(new int[] {1, 4, 4, 3, 2}));
        System.out.println(findNumber(new int[] {2, 1, 3, 3, 5, 4}));
        System.out.println(findNumber(new int[] {2, 4, 1, 4, 4}));
    }

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else { // we have found the duplicate
                    return nums[i];
                }
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
