package LeetCode.src.Explore.Interview.GoogleInterview.Others.UTF8Validation.Java;

public class Solution {
    public static void main(String[] args) {
        int[] data = {197, 130, 1};
        System.out.println(validUtf8(data));
    }

    /*
    Rule 2:
    Record the count of consecutive of 1.
    Move the number 5 bit right, if it equals "110" means there is one '1'.
    Move the number 4 bit right, if it equals "1110" means there are two '1'.
    ...
    Move the number 7 bit right, if it equals "1" means it is "10000000" which has no meaning, return false.

    Rule 1:
    If it is not started with "10", return false;
    */
    public static boolean validUtf8(int[] data) {
        int count = 0;
        for(int d:data) {
            if(count == 0) {
                if((d >> 5) == 0b110) count = 1;
                else if((d >> 4) == 0b1110) count = 2;
                else if((d >> 3) == 0b11110) count = 3;
                else if((d >> 7) ==  1) return false;
            } else {
                if((d >> 6) != 0b10) return false;
                else count--;
            }
        }
        return count == 0;
    }
}