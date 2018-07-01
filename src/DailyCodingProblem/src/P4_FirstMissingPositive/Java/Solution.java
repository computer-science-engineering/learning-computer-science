package DailyCodingProblem.src.P4_FirstMissingPositive.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 2, 0};
        int result = findMissingPositive(input);
        System.out.println(result);
    }

    /* Find the smallest positive missing 
       number in an array that contains
       all positive integers */
       static int findMissingPositive(int A[]) { 
        int size = A.length;

        // First separate positive and 
        // negative numbers
        int shift = segregate(A, size);
        int arr[] = new int[size-shift];
        int j=0;
        for(int i=shift;i<size;i++) {
            arr[j] = A[i];
            j++;
        }    
        // Shift the array and call 
        // findMissingPositive for
        // positive part
        return findMissing(arr, j);
    }
        
    private static int findMissing(int[] A, int size) {
        int i;
        // Mark A[i] as visited by making 
        // A[A[i] - 1] negative. Note that 
        // 1 is subtracted because index start 
        // from 0 and positive numbers start from 1
        for(i = 0; i < size; i++) {
            if(Math.abs(A[i]) - 1 < size && A[Math.abs(A[i]) - 1] > 0) {
                A[Math.abs(A[i]) - 1] = -A[Math.abs(A[i]) - 1];
            }
        }
        
        // Return the first index value at which 
        // is positive
        for(i = 0; i < size; i++) {
            if (A[i] > 0) {
                return i+1;  // 1 is added because indexes start from 0
            }
        }

        return size+1;
    }

    private static int segregate (int arr[], int size) {
        int j = 0, i;
        for(i = 0; i < size; i++) {
           if (arr[i] <= 0)  {
               int temp;
               temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               // increment count of non-positive 
               // integers
               j++;  
           }
        }
      
        return j;
    }
}