package EducativeIo.Courses.GrokkingTheCodingInterview.Ch03_TwoPointers.P1_PairWithTargetSum.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] result = search_TwoPointers(new int[] {1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = search_TwoPointers(new int[] {2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }

    public static int[] search_TwoPointers(int[] arr, int targetSum) {
        int startPointer = 0;
        int endPointer = arr.length - 1;
        while (startPointer < endPointer) {
            int currentSum = arr[startPointer] + arr[endPointer];
            if (currentSum > targetSum) {
                endPointer--;
            } else if (currentSum < targetSum) {
                startPointer++;
            } else {
                return new int[] {startPointer, endPointer};
            }
        }

        return new int[] {-1, -1};
    }

    public static int[] search_TwoPointers_IntOverflowFix(int[] arr, int targetSum) {
        int startPointer = 0;
        int endPointer = arr.length - 1;
        while (startPointer < endPointer) {
            // comparing the sum of two numbers to the 'targetSum' can cause integer overflow
            // so, we will try to find a target difference instead
            int targetDiff = targetSum - arr[startPointer];
            if (targetDiff == arr[endPointer]) {
                return new int[] {startPointer, endPointer}; // found the pair
            }

            if (targetDiff > arr[endPointer]) {
                startPointer++; // we need a pair with a bigger sum
            } else {
                endPointer--; // we need a pair with a smaller sum
            }
        }

        return new int[] {-1, -1};
    }

    public static int[] search_HashMap(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); // to store numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i])) {
                return new int[] {nums.get(targetSum - arr[i]), i};
            } else {
                nums.put(arr[i], i); // put the number and its index in the map
            }
        }
        return new int[] {-1, -1}; // pair not found
    }
}
