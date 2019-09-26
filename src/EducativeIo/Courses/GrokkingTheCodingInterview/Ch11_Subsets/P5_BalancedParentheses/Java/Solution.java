package EducativeIo.Courses.GrokkingTheCodingInterview.Ch11_Subsets.P5_BalancedParentheses.Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        List<String> result = generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("", 0, 0));
        while (!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            // if we've reached the maximum number of open and close parentheses, add to the result
            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) { // if we can add an open parentheses, add it
                    queue.add(new ParenthesesString(ps.str + "(", ps.openCount + 1, ps.closeCount));
                }
                if (ps.openCount > ps.closeCount) { // if we can add a close parentheses, add it
                    queue.add(new ParenthesesString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }
            }
        }
        return result;
    }

    public static List<String> generateValidParentheses2(int num) {
        List<String> result = new ArrayList<String>();
        char[] parenthesesString = new char[2 * num];
        generateValidParenthesesRecursive(num, 0, 0, parenthesesString, 0, result);
        return result;
    }

    private static void generateValidParenthesesRecursive(int num, int openCount, int closeCount,
            char[] parenthesesString, int index, List<String> result) {

        // if we've reached the maximum number of open and close parentheses, add to the result
        if (openCount == num && closeCount == num) {
            result.add(new String(parenthesesString));
        } else {
            if (openCount < num) { // if we can add an open parentheses, add it
                parenthesesString[index] = '(';
                generateValidParenthesesRecursive(num, openCount + 1, closeCount, parenthesesString,
                        index + 1, result);
            }

            if (openCount > closeCount) { // if we can add a close parentheses, add it
                parenthesesString[index] = ')';
                generateValidParenthesesRecursive(num, openCount, closeCount + 1, parenthesesString,
                        index + 1, result);
            }
        }
    }
}
