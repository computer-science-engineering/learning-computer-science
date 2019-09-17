package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P2_RemoveDuplicates.Variants.P1_RemoveAllInstancesOfK.Java;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(remove(arr, 3));

        arr = new int[] {2, 11, 2, 2, 1};
        System.out.println(remove(arr, 2));
    }

    public static int remove(int[] arr, int key) {
        int j = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] != key) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
