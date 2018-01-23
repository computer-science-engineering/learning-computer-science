package InterviewBit.src.Courses.Programming.Level4_StacksAndQueues.Examples.GenerateAllParentheses.Java;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(isValid("()[]{}"));
        System.out.println(isValid("])"));
    }
    
    public static int isValid(String A) {
        HashMap<Character, Character> open = new HashMap<Character, Character>();
        open.put('(', ')');
        open.put('{', '}');
        open.put('[', ']');
        char[] parenthesesClose = new char[]{ ')', '}', ']' };
        char[] input = A.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : input) {
            if (open.containsKey(c)) {
                stack.push(c);
            }
            else if (contains(c, parenthesesClose)) {
                if (stack.isEmpty()) {
                    return 0;
                }
                char openEquivalent = stack.pop();
                char expectedClose = open.get(openEquivalent);
                if (expectedClose != c) {
                    return 0;
                }
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static boolean contains(char c, char[] compare) {
        for (int i=0; i<compare.length; i++) {
            if (compare[i] == c) {
                return true;
            }
        }
        return false;
    }
}