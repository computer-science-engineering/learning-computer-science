package Courses.Programming.Level2_Math.Examples.VerifyPrime;

public class Solution {
    public static void main(String[] args) {
        int result = isPrime(10);
        System.out.println(result);
    }

    public static int isPrime(int A) {
        if (A == 1) {
            return 0;
        }
        int upperLimit = (int)(Math.sqrt(A));
        for (int i = 2; i <= upperLimit; i++) {
            if (i < A && A % i == 0) { 
                return 0;
            }
        }
        return 1;
    }    
}