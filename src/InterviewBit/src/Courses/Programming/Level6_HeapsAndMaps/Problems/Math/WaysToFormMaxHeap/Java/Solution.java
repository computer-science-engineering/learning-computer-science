package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Math.WaysToFormMaxHeap.Java;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solve(20)); // 20 - 258365767 ; 4-3
    }
    
    public static int solve(int A) {
        if (A <= 1) {
            return 1;
        }
    
        int h = (int)(Math.log(A) / Math.log(2)) + 1;        
        int pow = (int)Math.pow(2, h - 1);        
        int maxLast = pow;
        int actualLast = A - (pow - 1);
        
        int l;
        if (actualLast >= maxLast / 2) {
            l = pow - 1;
        }
        else {
            l = pow - 1 - (maxLast / 2 - actualLast);
        }
        
        long subResult = ((long)solve(l) * (long)solve(A - 1 - l)) % 1000000007;
        long res = (combinationNcK(l, A - 1) * subResult) % 1000000007;
            
        return (int)res;
    }

    private static long combinationNcK(int k, int n) {
        // long res = 1;
        // for (long i = k + 1; i <= n; i++) {
        //     res *= i;
        //     res /= i - k;
        // }         
        // return res % 1000000007;
        BigInteger factorial_n = factorial(n);
        BigInteger factorial_k = factorial(k);
        BigInteger factorial_nk = factorial(n - k);
        BigInteger denominator = factorial_k.multiply(factorial_nk);
        long res = factorial_n.divide(denominator).longValue();
        return res % 1000000007;
    }

    private static BigInteger factorial(int value){
        if(value < 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
    
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
    
        return result;
    }    
}