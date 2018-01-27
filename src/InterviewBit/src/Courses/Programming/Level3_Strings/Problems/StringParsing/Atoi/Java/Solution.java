package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringParsing.Atoi.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(atoi("9 2704"));
    }
    
    public static int atoi(final String A) {
        if (A == null || A.length() < 1) {
            return 0;
        }
 
        // trim white spaces
        String B = A.trim();
    
        char flag = '+';
    
        // check negative or positive
        int i = 0;
        if (B.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (B.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
    
        // calculate value
        while (B.length() > i && B.charAt(i) >= '0' && B.charAt(i) <= '9') {
            result = result * 10 + (B.charAt(i) - '0');
            i++;
        }
    
        if (flag == '-') {
            result = -result;
        }
    
        // handle max and min
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
    
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
    
        return (int) result;
    }
}