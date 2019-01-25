package LeetCode.src.Problems.P1_P100.P7_ReverseInteger.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        long rev= 0;
        while(x != 0) {
            rev = rev*10 + x%10;
            x = x/10;
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) rev;
    }
}