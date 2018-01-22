package InterviewBit.src.Courses.Programming.Level3_TwoPointers.Problems.Tricks.ContainerWithMostWater.Java;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 5, 4, 3};
        System.out.println(maxArea(input));
    }

    public static int maxArea(int[] A) {
        int maxarea = 0, l = 0, r = A.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(A[l], A[r]) * (r - l));
            if (A[l] < A[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxarea;
    }    
}