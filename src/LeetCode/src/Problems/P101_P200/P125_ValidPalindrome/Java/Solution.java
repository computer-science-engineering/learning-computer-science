package LeetCode.src.Problems.P101_P200.P125_ValidPalindrome.Java;

public class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int i = 0;
        int j = ch.length-1;
        while(i<j) {
            if (!Character.isLetterOrDigit(ch[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(ch[j])) {
                j--;
                continue;
            }
            if (ch[i] != ch[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}