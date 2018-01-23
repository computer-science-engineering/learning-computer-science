package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.CleverStack.LargestRectangleInHistogram.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //int[] input = new int[]{2, 1, 5, 6, 2, 3};
        int[] input = new int[]{6, 2, 5, 4, 5, 1, 6};
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
                int area = A[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }
}