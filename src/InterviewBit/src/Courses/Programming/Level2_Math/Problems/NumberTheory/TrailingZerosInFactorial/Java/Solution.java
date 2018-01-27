package InterviewBit.src.Courses.Programming.Level2_Math.Problems.NumberTheory.TrailingZerosInFactorial.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(3125)); //4617
    }

    public static int trailingZeroes(int A) {
        int result = 0;
        int power = 1;
        while((float)(A/(Math.pow(5, power))) >= 1) {
            result += (int)(A/(Math.pow(5, power)));
            power++;
        }
        return result;
    }
}