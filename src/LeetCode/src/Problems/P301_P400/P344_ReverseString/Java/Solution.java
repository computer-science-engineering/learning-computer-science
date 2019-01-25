package LeetCode.src.Problems.P301_P400.P344_ReverseString.Java;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }

    public static String reverseString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=ch.length-1; i>=0; i--) {
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}