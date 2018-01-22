package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringMath.AddBinaryStrings;

public class Solution {
    public static void main(String[] args) {
        System.out.println(addBinary("100", "11"));
    }
    
    public static String addBinary(String A, String B) {
        String result = ""; // Initialize result
        int s = 0;          // Initialize digit sum
    
        // Traverse both strings starting from last
        // characters
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {
            // Compute sum of last digits and carry
            s += ((i >= 0)? A.charAt(i) - '0': 0);
            s += ((j >= 0)? B.charAt(j) - '0': 0);
    
            // If current digit sum is 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;
    
            // Compute carry
            s /= 2;
    
            // Move to next digits
            i--; 
            j--;
        }
        return result;
    }
}