package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow._Introduction_P0_AverageOfSubarrayOfSizeK.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
      int K = 5;
      int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2 };
      double[] result_Naive = findAverages_naive(K, arr);
      double[] result_SlidingWindow = findAverages_slidingWindow(K, arr);
      System.out.println("Averages of subarrays of size K: " + Arrays.toString(result_Naive));
      System.out.println("Averages of subarrays of size K: " + Arrays.toString(result_SlidingWindow));
    }

    public static double[] findAverages_naive(int K, int[] arr) {
      double[] result = new double[arr.length - K + 1];
      for (int i = 0; i <= arr.length - K; i++) {
        // find sum of next 'K' elements
        double sum = 0;
        for (int j = i; j < i + K; j++)
          sum += arr[j];
        result[i] = sum / K; // calculate average
      }
  
      return result;
    }

    public static double[] findAverages_slidingWindow(int K, int[] arr) {
      double[] result = new double[arr.length - K + 1];
      double windowSum = 0;
      int windowStart = 0;
      for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; // add the next element
        // slide the window, we don't need to slide if we've not hit the required window size of 'k'
        if (windowEnd >= K - 1) {
          result[windowStart] = windowSum / K; // calculate the average
          windowSum -= arr[windowStart]; // subtract the element going out
          windowStart++; // slide the window ahead
        }
      }
  
      return result;
    }
}