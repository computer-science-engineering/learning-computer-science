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

    public static int largestRectangleArea_explained(int[] A) {
        int max = 0;
        int size = A.length;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= size;) {
            // last bar as size 0 to collect all other bars
            int bar = i < size ? A[i] : 0;
            if (stack.isEmpty() || bar >= A[stack.peek()]) {
                // when bar is larger, push bar into stack
                stack.push(i);
                // move right boundary
                i++;
            } else {
                // when bar is smaller, use stack's top bar as height
                int height = A[stack.pop()];
                // remove bars with the same height from stack
                while (!stack.isEmpty() && height == A[stack.peek()]) {
                    stack.pop();
                }
                // if stack is NOT empty, left boundary is (stack's top bar + 1)
                // if stack is empty(bar is smallest), left boundary is 0
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                // right boundary is (i - 1)
                // so width is (i - left)
                max = Math.max(max, height * (i - left));
                // since we didn't move right boundary, going to calculate all bigger bars in stack
            }
        }
        return max;
    }
}