package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.P2_RemoveDuplicates.Java;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(arr));

        arr = new int[] {2, 2, 2, 11};
        System.out.println(remove(arr));
    }

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
}
