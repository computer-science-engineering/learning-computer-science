package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.Sorting.ThreeSum.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] A = {-1, 2, 1, -4};
        int B = 1;
        System.out.println(threeSumClosest(A, B));
    }    

    public static int threeSumClosest(int[] A, int B) {
        int min = Integer.MAX_VALUE;
        int result = 0;
    
        Arrays.sort(A);
    
        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                int diff = Math.abs(sum - B);
    
                if(diff == 0) return sum;
    
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= B) {
                    j++;
                } else {
                    k--;
                }
            }
        }    
        return result;
    }
}