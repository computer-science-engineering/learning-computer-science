package LeetCode.src.Problems.P1_P100.P50_Pow_x_n.Java;

public class Solution {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            return myPow(x, Integer.MIN_VALUE + 1) / x;
        } else if(n<0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}