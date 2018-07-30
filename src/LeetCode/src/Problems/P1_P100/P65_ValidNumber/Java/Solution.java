package LeetCode.src.Problems.P1_P100.P65_ValidNumber.Java;

public class Solution {
    public static void main(String[] args) {
        String s = "0";
        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        try {
            s = s.trim();
            int n = s.length();
            if ( n == 0 || (s.charAt(n-1) != '.' && (s.charAt(n-1) - '0' < 0 || s.charAt(n-1) - '0' > 9 )) ) {
                return false;
            }
            double i = Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}