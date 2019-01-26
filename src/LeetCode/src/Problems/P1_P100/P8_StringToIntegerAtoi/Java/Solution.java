package LeetCode.src.Problems.P1_P100.P8_StringToIntegerAtoi.Java;

public class Solution {
    public static void main(String[] args) {
        String str = "   -42";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
 
        // trim white spaces
        String B = str.trim();

        if (B.length() == 0) {
            return 0;
        }
    
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