package HackerRank.src.Tutorials.ThirtyDaysOfCode.D20_Sorting;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        String input = scan.nextLine();

        String[] parts = input.split(" ");
        int[] a = Solution.SanitizeArray(n, parts);
        Solution.DoJob(n, a);
        scan.close();
    }

    public static void DoJob(int n, int[] a){
        int numberOfSwapsTotal = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    //swap(a[j], a[j + 1]);
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }
            }

            numberOfSwapsTotal = numberOfSwapsTotal + numberOfSwaps;

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }

        System.out.println("Array is sorted in " + numberOfSwapsTotal + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);
    }

    public static int[] SanitizeArray(int n, String[] a){
        int[] res = new int[n];
        int i=0;
        for (String s : a){
            res[i] = Integer.parseInt(s);
            i++;
        }
        return res;
    }
}
