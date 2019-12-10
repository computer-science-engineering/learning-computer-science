package Miscellaneous.src.Problems.Coding.CommonLettersInInputStrings.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String word1 = "aeiou", word2 = "abcabc";
        System.out.println(getCommonLetters(word1, word2));
    }

    public static String getCommonLetters(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Character> tracking  = new HashMap<Character, Character>();

        char[] smallerStringCharArray = word1.length() < word2.length() ? word1.toCharArray() : word2.toCharArray();
        char[] largerStringCharArray = word1.length() >= word2.length() ? word1.toCharArray() : word2.toCharArray();
        
        for(char ch : smallerStringCharArray) {
            if (!tracking.containsKey(ch)) {
                tracking.put(ch, ch);
            }
        }
        
        for(char ch : largerStringCharArray) {
            if (tracking.containsKey(ch)) {
                sb.append(ch);
                tracking.remove(ch);
            }
            if (tracking.isEmpty()) { 
                break; 
            }
        }
        
        return sb.toString();
    }        
}