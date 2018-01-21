package Courses.Programming.Level3_TwoPointers.Problems.TwoPointer.MinimizeAbsoluteDifference.Java;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8, 10}; 
        int[] B = {6, 9, 15};
        int[] C = {2, 3, 6, 6};
        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, int[] B, int[] C) {
        int diff = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i, j, k;
        for(i = 0, j = 0, k = 0; i < A.length && j < B.length && k < C.length;) {
            min = Math.min(A[i], Math.min(B[j], C[k]));
            max = Math.max(A[i], Math.max(B[j], C[k]));
            diff = Math.min(diff, max - min);
            if(diff == 0) {
                break;
            }
            if(A[i] == min) {
                i++;
            }
            else if(B[j] == min) {
                j++;
            }
            else {
                k++;
            }
        }
        return diff;
    }
}