package LeetCode.src.Problems.P301_P400.P367_ValidPerfectSquare.Java;

public class Solution {
    public static void main(String[] args) {
        int num = 16;
        System.out.println(isPerfectSquare(num));
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 1) {
            return false;
        }
        long left = 1, right = num; // long type to avoid 2147483647 case

        while (left <= right) {
            long mid = left + (right - left)/2; //(left + right) >> 1;
            long square_mid = mid * mid;
            if (square_mid > num) {
                right = mid - 1;
            }
            else if (square_mid < num) {
                left = mid + 1;
            }
            else {
                return num % mid == 0; //true;
            }
        }

        return false;
    }
}