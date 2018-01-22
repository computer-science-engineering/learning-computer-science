package InterviewBit.src.Courses.Programming.Level2_Math.Problems.DigitOp.PalindromeInteger;


public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12345));
    }

    public static int isPalindrome(int A) {
        if (A < 0){
            return 0;
        }
        if (A == reverse(A)) {
            return 1;
        }
        return 0;
    }

    public static int reverse(int A) {
        long reversedNum = 0;        
        long input_long = A;    
        while (input_long != 0)
        {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }    
        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
        {
            reversedNum = 0;
        }
        return (int)reversedNum;
    } 
}