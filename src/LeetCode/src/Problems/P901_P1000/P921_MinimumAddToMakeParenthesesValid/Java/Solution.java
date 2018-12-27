package LeetCode.src.Problems.P901_P1000.P921_MinimumAddToMakeParenthesesValid.Java;

public class Solution {
    public static void main(String[] args) {
        String S = "()))((";
        System.out.println(minAddToMakeValid(S));
    }

    public static int minAddToMakeValid(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }
}