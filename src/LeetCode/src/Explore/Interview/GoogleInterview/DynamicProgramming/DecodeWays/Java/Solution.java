package LeetCode.src.Explore.Interview.GoogleInterview.DynamicProgramming.DecodeWays.Java;

public class Solution {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            else {
                int valueAtCurrentIndex = Integer.parseInt(s.substring(i,i+2));
                memo[i] = (valueAtCurrentIndex<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
            }
        }
        
        return memo[0];
    }
}