package Courses.Programming.Level2_Math.Problems.NumberTheory.GreatestCommonDivisor;

public class Solution {
    public static void main(String[] args) {
        System.out.println(gcd(4, 16));
    }

    public static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}