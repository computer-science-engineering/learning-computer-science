package EducativeIo.GrokkingTheCodingInterview.Ch03_TwoPointers.P8_DutchNationalFlagProblem.Java;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 2, 1, 0};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        arr = new int[] {2, 2, 0, 1, 2, 0};
        sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if (arr[i] == 0) {
                swap(arr, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (arr[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(arr, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
