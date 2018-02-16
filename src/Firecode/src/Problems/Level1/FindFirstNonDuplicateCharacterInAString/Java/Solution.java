package Firecode.src.Problems.Level1.FindFirstNonDuplicateCharacterInAString.Java;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("abcdcd"));
    }

    public static Character firstNonRepeatedCharacter(String str) {
        int length = str.length();
        HashMap<Character, Integer> occurrences = new HashMap<Character, Integer>();
        for (int i=0; i<length; i++) {
            Character ch = str.charAt(i);
            if (!occurrences.containsKey(ch)) {                
                occurrences.put(ch, 1);
            }
            else {
                int soFar = occurrences.get(ch);               
                occurrences.replace(ch, soFar+1);
            }
        }
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }    
}