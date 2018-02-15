package InterviewBit.src.Courses.Programming.Level5_Backtracking.Problems.PrunedBuilder.GenerateAllParentheses2.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> result = generateParenthesis(3);
        for (String item : result) {
            System.out.println(item);
        }
    }

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, A);
        return list;
    }
    
    private static void backtrack(List<String> list, String str, int open, int close, int max) {        
        if(str.length() == max*2) {
            list.add(str);
            return;
        }
        
        if(open < max) {
            backtrack(list, str+"(", open+1, close, max);
        }

        if(close < open) {
            backtrack(list, str+")", open, close+1, max);
        }
    }
}