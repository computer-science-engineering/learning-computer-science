# Problem Definition

## Description

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

You can modify the input array in-place.

## Notes

1. [Geeks for Geeks - Find the smallest positive number missing from an unsorted array | Set 1](https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/)

    ```java
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
    ```
1. [ProgramCreek - First Missing Positive](https://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/)
1. [LeetCode discussion - Very Easy Java Solution in O(n) time and constant space](https://leetcode.com/explore/interview/card/google/59/array-and-strings/457/discuss/130739/Very-Easy-Java-Solution-in-O\(n\)-time-and-constant-space)
1. [LeetCode discussion - O(1) space Java Solution](https://leetcode.com/explore/interview/card/google/59/array-and-strings/457/discuss/17083/O(1)-space-Java-Solution)
1. [LeetCode discussion - Beat 100% Fast Elegant Java Index-Based Solution with Explanation](https://leetcode.com/explore/interview/card/google/59/array-and-strings/457/discuss/17126/Beat-100-Fast-Elegant-Java-Index-Based-Solution-with-Explanation)
1. [Coding Today — Finding First Missing Positive Integers the Right Way](https://blog.vcillusion.co.in/finding-first-missing-positive-integers-the-right-way/)
