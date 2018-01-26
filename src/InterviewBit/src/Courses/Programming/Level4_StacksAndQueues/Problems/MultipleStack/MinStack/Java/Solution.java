package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.MultipleStack.MinStack.Java;

import java.util.*;

public class Solution {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public Solution() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args) {
        Solution minStack = new Solution();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); //-3
        minStack.pop();
        System.out.println(minStack.top()); // 0.
        System.out.println(minStack.getMin()); // -2.
    }

    public void push(int x) {
        stack.push(x);    
        if(minStack.isEmpty() || x <= minStack.peek())  {
            minStack.push(x);
        }
    }
    
    public void pop() {        
        if(!stack.isEmpty()) {
            int num = stack.pop();
            if(num == minStack.peek()) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }    
}