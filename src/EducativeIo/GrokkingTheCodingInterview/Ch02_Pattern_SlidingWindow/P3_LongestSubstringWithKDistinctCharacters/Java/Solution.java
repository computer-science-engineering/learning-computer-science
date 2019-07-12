package EducativeIo.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.P3_LongestSubstringWithKDistinctCharacters.Java;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + findLength("cbbebi", 3));  
    }

    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int longestSubstringLength = Integer.MIN_VALUE;
        int windowStart = 0;
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char currentChar = str.charAt(windowEnd);
            charFrequencyMap.put(currentChar, charFrequencyMap.getOrDefault(currentChar, 0) + 1);
            
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }
            longestSubstringLength = Math.max(longestSubstringLength, windowEnd - windowStart + 1);
        }
        return longestSubstringLength;
    }
}