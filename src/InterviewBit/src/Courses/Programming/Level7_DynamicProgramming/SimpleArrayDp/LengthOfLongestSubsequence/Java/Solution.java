package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.SimpleArrayDp.LengthOfLongestSubsequence.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] A = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(longestSubsequenceLength(A));
    }

    public static int longestSubsequenceLength(final int[] A) {
        int n = A.length;

        if(n<2) {
            return n;
        }

        int[] longestIncreasingSubsequenceArr = new int[n];
        Arrays.fill(longestIncreasingSubsequenceArr, 1);
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if( A[j] < A[i] && longestIncreasingSubsequenceArr[i] < 1 + longestIncreasingSubsequenceArr[j] ) {
                    longestIncreasingSubsequenceArr[i] = 1 + longestIncreasingSubsequenceArr[j];
                }
            }
        }

        int[] longestDecreasingSubsequenceArr = new int[n];
        Arrays.fill(longestDecreasingSubsequenceArr, 1);
        for(int i=n-2; i>=0; i--) {
            for(int j=i+1; j<n; j++) {
                if( A[j] < A[i] && longestDecreasingSubsequenceArr[i] < 1 + longestDecreasingSubsequenceArr[j] ) {
                    longestDecreasingSubsequenceArr[i] = 1 + longestDecreasingSubsequenceArr[j];
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++) {
            if( longestIncreasingSubsequenceArr[i] + longestDecreasingSubsequenceArr[i] > max ) {
                max = longestIncreasingSubsequenceArr[i] + longestDecreasingSubsequenceArr[i];
            }
        }
        return max-1;
    }    
}