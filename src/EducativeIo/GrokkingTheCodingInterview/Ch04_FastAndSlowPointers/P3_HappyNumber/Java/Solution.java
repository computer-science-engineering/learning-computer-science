package EducativeIo.GrokkingTheCodingInterview.Ch04_FastAndSlowPointers.P3_HappyNumber.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(find(23));
        System.out.println(find(12));
    }

    public static boolean find(int num) {
        int slow = num, fast = num;
        do {
            slow = findSquareSum(slow); // move one step
            fast = findSquareSum(findSquareSum(fast)); // move two steps
        } while (slow != fast); // found the cycle

        return slow == 1; // see if the cycle is stuck on the number '1'
    }

    private static int findSquareSum(int num) {
        int sum = 0, digit;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}
