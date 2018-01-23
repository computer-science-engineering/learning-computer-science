package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Examples.ReverseString.Java;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
    }
    
    public static String reverseString(String A) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : A.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}