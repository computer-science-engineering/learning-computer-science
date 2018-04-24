package InterviewBit.src.Courses.Programming.Level2_Math.Problems.DigitOp.ReverseInteger.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-1146467285));
    }

    public static int reverse(int A) {
        long reversedNum = 0;        
        long input_long = A;    
        while (input_long != 0) {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }    
        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            //throw new IllegalArgumentException();
            reversedNum = 0;
        }
        return (int)reversedNum;
    }    
}