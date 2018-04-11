package InterviewBit.src.Courses.Programming.Level7_DynamicProgramming.PreProcessDp.MaxRectangleInBinaryMatrix.Java;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int A[][] = { {1},
                    };
        System.out.println(maximalRectangle(A));
    }
    
    public static int maximalRectangle(int[][] A) {
        int temp[] = new int[A[0].length];
        int maxArea = 0;
        int area = 0;
        for(int i=0; i < A.length; i++) {
            for(int j=0; j < temp.length; j++) {
                if(A[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] += A[i][j];
                }
            }
            area = maxAreaInHistogram(temp);
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static int maxAreaInHistogram(int[] input) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;) {
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everything from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if(area > maxArea){
                    maxArea = area;
            }
        }
        return maxArea;
    }
}