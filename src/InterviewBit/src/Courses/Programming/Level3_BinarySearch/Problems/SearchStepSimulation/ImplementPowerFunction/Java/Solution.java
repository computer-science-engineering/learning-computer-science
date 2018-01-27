package InterviewBit.src.Courses.Programming.Level3_BinarySearch.Problems.SearchStepSimulation.ImplementPowerFunction.Java;

public class Solution {
    public static void main(String[] args) {
        int result = pow(2, 3, 3);
        System.out.println(result);
    }
    
    public static int pow(int x, int n, int d) {
        if (x == 0) {
            return 0;
        }
        long a1 = x % d;
        long p = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                p = (p * a1) % d;
            }
            n /= 2;
            a1 = (a1 * a1) % d;
        }
        if (p < 0) {
            return (int) ((p + d) % d);
        } else {
            return (int) p;
        }
    }
    
    public static double pow2(double x, int n) {
        if (n == 0)  {
            return 1;
        }
        if (n == 2) {
            return x * x;
        }
        if (n % 2 == 0) {
            return pow2(pow2(x, n / 2), 2);
        }
        else if (n > 0) {
            return x * pow2(pow2(x, n / 2), 2);
        }
        else {
            return 1 / x * pow2(pow2(x, n / 2), 2);
        }
    }
}