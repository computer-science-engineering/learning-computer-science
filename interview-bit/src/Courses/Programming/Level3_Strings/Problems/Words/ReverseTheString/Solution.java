package Courses.Programming.Level3_Strings.Problems.Words.ReverseTheString;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String a) {
        a = a.replaceAll("\\s+", " ");
        String[] words = a.split(" ");
        String result = "";
        for(int i=words.length-1; i>=0; i--) {
            result += words[i] + " ";
        }
        return result.trim();
	}    
}