package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.CleverStack.LargestRectangleInHistogram.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] input = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(input));
    }
    
    public static int largestRectangleArea(int[] A) {
        int len = A.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : A[i]);
            if(s.isEmpty() || h >= A[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, A[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}