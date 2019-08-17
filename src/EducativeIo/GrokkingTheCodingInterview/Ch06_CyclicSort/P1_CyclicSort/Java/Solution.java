package EducativeIo.GrokkingTheCodingInterview.Ch06_CyclicSort.P1_CyclicSort.Java;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 1, 5, 4, 2};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[] {2, 6, 4, 3, 1, 5};
        sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
