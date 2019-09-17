package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P2_SmallestSubarrayWithAGivenSum.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }

    public static int findMinSubArray(int S, int[] arr) {
        int result = Integer.MAX_VALUE;
        int windowStart = 0;
        int windowSum = 0;
        int windowStartFinal = 0, windowEndFinal = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];

            while (windowSum >= S) {
                int windowSize = (windowEnd - windowStart) + 1;

                if(windowSize <= result) {
                    windowStartFinal = windowStart;
                    windowEndFinal = windowEnd;
                }

                result = Math.min(result, windowSize);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        int index = 0;
        int[] resultArray = new int[result];
        for (int i=windowStartFinal; i<=windowEndFinal; i++) {
            resultArray[index++] = arr[i];
        }
        System.out.println(Arrays.toString(resultArray));
        
        return result;
      }
}