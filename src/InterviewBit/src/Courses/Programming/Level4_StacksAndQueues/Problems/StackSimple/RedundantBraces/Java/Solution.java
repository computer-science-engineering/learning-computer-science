package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Problems.StackSimple.RedundantBraces.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String input = "(a + (a + b))"; //"((a + b))"
        System.out.println(braces(input));
    }

    public static int braces(String A) {
        Stack<Character> stack = new Stack<Character>(); 
        int index = 0; 
        while(index < A.length()) { 
            char c = A.charAt(index); 
            if(c == '(' || c == '+' || c == '-' || c == '*' || c == '/') { 
                stack.push(c); 
            } 
            else if(c == ')') { 
                if(stack.peek() == '(') { 
                    return 1; 
                } else { 
                    while(!stack.isEmpty() && stack.peek() != '(') { 
                        stack.pop(); 
                    } 
                    stack.pop(); 
                } 
            } 
            index++; 
        } 
        return 0; 
    }    
}