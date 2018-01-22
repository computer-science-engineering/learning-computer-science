package InterviewBit.src.Courses.Programming.Level2_Arrays.Problems.Bucketing.NobleInteger;

import java.util.*;

/**
 * https://www.interviewbit.com/problems/noble-integer/
 */
public class Solution {
    public static void main(String[] args) { 
        int[] input = {1, 2, 2, 3};
        int result = solve(input);
        System.out.println(result);
    }    

    public static int solve(int[] A) {
        Arrays.sort(A);

        // Return a Noble element if present
        // before last.
        int n = A.length;
        for (int i=0; i<n-1; i++)
        {
            if (A[i] == A[i+1]) {
                continue;
            }
 
            // In case of duplicates, we
            // reach last occurrence here.
            if (A[i] == n-i-1)
                return 1;
        }
 
        if (A[n-1] == 0) {
            return 1;
        }

        return -1;
    }
}