package Courses.Programming.Level2_Arrays.Problems.BucketingOrSorting.WaveArray;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) { 
        int[] input = {5, 1, 3, 2, 4};
        int[] result = wave(input);
        Arrays.stream(result).forEach(num -> { 
            System.out.print(num + " "); 
        });
    }

    public static int[] waveSimple(int[] A) {
        Arrays.sort(A);
        for (int i=0; i<A.length-1; i++) {
            swap(A, i,i+1);
        }
        return A;
    }

    public static int[] wave(int[] A) {
        Arrays.sort(A);
        for (int i=0; i<A.length; i+=2) {
            // If current even element is smaller than previous
            if (i>0 && A[i-1]>A[i]) {
                swap(A, i-1, i);
            }
            
            // If current even element is smaller than next
            if (i<A.length-1 && A[i]<A[i+1]) {
                swap(A, i, i+1);
            }
        }

        return A;
    }

    private static void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}