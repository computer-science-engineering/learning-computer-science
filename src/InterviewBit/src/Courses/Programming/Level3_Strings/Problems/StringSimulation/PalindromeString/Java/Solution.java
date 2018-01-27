package InterviewBit.src.Courses.Programming.Level3_Strings.Problems.StringSimulation.PalindromeString.Java;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(isPalindrome("A man, a plan, a canal: Panama"));        
        //System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("1a2"));
    }

    public static int isPalindrome(String a) {
        String b = cleanseString(a);
        int start = 0;
        int end = b.length()-1;
        while (end > start) {
            if (b.charAt(start) != b.charAt(end)) {
                return 0;
            }
            ++start;
            --end;
        }
        return 1;
    }
    
    public static int isPalindrome2(String a) {
        String b = cleanseString(a);
        String reverse = "";
        for (int i=b.length()-1; i>=0; i--) {
            reverse = reverse + b.charAt(i);
        }
        if (b.equals(reverse)) {
            return 1;
        }
        return 0;
    }
    
    private static String cleanseString(String input){
        return input.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }
}