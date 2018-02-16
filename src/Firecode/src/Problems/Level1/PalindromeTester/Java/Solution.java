package Firecode.src.Problems.Level1.PalindromeTester.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isStringPalindrome("madam"));
    }

    public static boolean isStringPalindrome(String str){
        if (str == null || str == "") {
            return true;
        }
        int low = 0;
        int high = str.length()-1;
        while (low < high) {
            if (str.charAt(low++) != str.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}