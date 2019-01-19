package LeetCode.src.Explore.Interview.GoogleInterview.ArraysAndStrings.ValidNumber.Java;

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
            System.out.println(i);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumber2(String s) {
        s = s.toLowerCase().trim();
        boolean dotSeen = false;
        boolean eSeen   = false;
        boolean numberBeforeE = false;
        boolean numberAfterE  = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ('0' <= cur && cur <= '9') {
                if (!eSeen) numberBeforeE = true;
                if (eSeen)  numberAfterE  = true;
            } else if (cur == '-' || cur == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (cur == '.') {
                if (eSeen || dotSeen) return false;
                dotSeen = true;
            } else if (cur == 'e' ) {
                if (eSeen) return false;
                eSeen = true;
            } else { // invalid chars
                return false;
            }
        }
        return eSeen ? (numberBeforeE && numberAfterE) : numberBeforeE;
    }
}