package Miscellaneous.src.Problems.MappingBetweenMessageAndCode.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        String message = "red green blue";
        String code = "abc";
        System.out.println(doesMappingExist(message, code));
    }

    public static boolean doesMappingExist(String message, String code) {
        String[] words = message.split(" ");
        HashMap<String, Character> map = new HashMap<>();
        char[] letters = code.toCharArray();
        
        // edge cases
        if (words.length != letters.length) {
            return false;
        }
        
        int charArrayIndex = 0;
        for(String word : words) {
            char letter = letters[charArrayIndex++];
            if (!map.containsKey(word)) {
                if (map.containsValue(letter)) {
                    return false;
                }
                map.put(word, letter);
            }
            char extantChar = map.get(word);
            if (extantChar != letter) {
                return false;
            }
            
        }
        
        return true;
    }
}