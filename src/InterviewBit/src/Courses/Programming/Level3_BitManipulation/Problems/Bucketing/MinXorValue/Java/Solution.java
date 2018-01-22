package InterviewBit.src.Courses.Programming.Level3_BitManipulation.Problems.Bucketing.MinXorValue.Java;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] input = {15, 5, 1, 10, 2};
        System.out.println(findMinXor(input));
    }

    public static int findMinXor(int[] A) {
        Arrays.sort(A);
        int result = Integer.MAX_VALUE;
        for(int i=0; i<A.length-1; i++) {
            result = Math.min(result, A[i] ^ A[i+1]);
        }
        return result;
    }

    public static int findMinXor_dumb(int[] A) {
        int result = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++) {
            for (int j=0; j<A.length-1; j++) {
                if (i != j) {
                    result = Math.min(result, A[i] ^ A[j]);
                }
            }
        }
        return result;
    }
}