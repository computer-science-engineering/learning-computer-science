package Pramp.src.Problems.DataStructuresAndAlgorithms.ArrayQuadruplet.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        int s = 20;
        int[] result = findArrayQuadruplet(arr, s);
        for (int i=0; i<result.length; i++) {      
            System.out.print(result[i] + " ");
        }
    }

    public static int[] findArrayQuadruplet(int[] arr, int s) {
        int n = arr.length;
        if (n < 4) {
            return new int[]{};
        }
        
        Arrays.sort(arr);
        for(int i=0; i<n-4; i++) {
          for (int j=i+1; j<n-3; j++) {
            int r = s - (arr[i] + arr[j]);
            int low = j + 1, high = n - 1;
            while (low < high) {
               if (arr[low] + arr[high] < r) {
                 low++;
               } else if (arr[low] + arr[high] > r) {
                 high--;
               } else {
                 return new int[]{arr[i], arr[j], arr[low], arr[high]};
               }
            }
          }
        }
        return new int[]{};
    }
}