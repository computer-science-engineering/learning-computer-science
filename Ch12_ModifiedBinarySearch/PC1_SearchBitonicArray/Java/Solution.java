package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.PC1_SearchBitonicArray.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(search(new int[] {1, 3, 8, 4, 3}, 4));
        System.out.println(search(new int[] {3, 8, 3, 1}, 8));
        System.out.println(search(new int[] {1, 3, 8, 12}, 12));
        System.out.println(search(new int[] {10, 9, 8}, 10));
    }

    public static int search(int[] arr, int key) {
        int maxIndex = findMax(arr);
        int keyIndex = binarySearch(arr, key, 0, maxIndex);
        if (keyIndex != -1)
            return keyIndex;
        return binarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    // find index of the maximum value in a bitonic array
    private static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // at the end of the while loop, 'start == end'
        return start;
    }

    // order-agnostic binary search
    private static int binarySearch(int[] arr, int key, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (key == arr[mid])
                return mid;

            if (arr[start] < arr[end]) { // ascending order
                if (key < arr[mid]) {
                    end = mid - 1;
                } else { // key > arr[mid]
                    start = mid + 1;
                }
            } else { // descending order
                if (key > arr[mid]) {
                    end = mid - 1;
                } else { // key < arr[mid]
                    start = mid + 1;
                }
            }
        }
        return -1; // element is not found
    }

}
