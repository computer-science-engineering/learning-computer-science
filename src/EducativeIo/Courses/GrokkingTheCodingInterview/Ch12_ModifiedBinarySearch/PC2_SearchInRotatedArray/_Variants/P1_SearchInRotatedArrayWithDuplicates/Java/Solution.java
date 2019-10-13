package EducativeIo.Courses.GrokkingTheCodingInterview.Ch12_ModifiedBinarySearch.PC2_SearchInRotatedArray._Variants.P1_SearchInRotatedArrayWithDuplicates.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(search(new int[] {3, 3, 7, 3}, 7));
    }

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            }

            // the only difference from the previous solution,
            // if numbers at indexes start, mid, and end are same, we can't choose a side
            // the best we can do, is to skip one number from both ends as key != arr[mid]
            if ((arr[start] == arr[mid]) && (arr[end] == arr[mid])) {
                ++start;
                --end;
            } else if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
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
