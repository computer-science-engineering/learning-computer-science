package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.PC2_SearchInRotatedArray.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(search(new int[] {10, 15, 1, 3, 8}, 15));
        System.out.println(search(new int[] {4, 5, 7, 9, 10, -1, 2}, 10));
    }

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;

            if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else { // key > arr[mid]
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // we are not able to find the element in the given array
        return -1;
    }
}
