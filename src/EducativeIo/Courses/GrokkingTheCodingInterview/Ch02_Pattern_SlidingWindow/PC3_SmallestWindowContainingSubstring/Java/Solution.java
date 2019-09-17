package EducativeIo.Courses.GrokkingTheCodingInterview.Ch02_Pattern_SlidingWindow.PC3_SmallestWindowContainingSubstring.Java;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findPermutation("aabdec", "abc"));
        System.out.println(findPermutation("abdabca", "abc"));
        System.out.println(findPermutation("adcad", "abc"));
    }

    public static String findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0, minLength = str.length() + 1, subStrStart = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
                if (charFrequencyMap.get(rightChar) >= 0) { // count every matching of a character
                    matched++;
                }

                // shrink the window if we can, finish as soon as we remove a matched character
                while (matched == pattern.length()) {
                    if (minLength > windowEnd - windowStart + 1) {
                        minLength = windowEnd - windowStart + 1;
                        subStrStart = windowStart;
                    }

                    char leftChar = str.charAt(windowStart++);
                    // if the character going out was part of the pattern, put it back in the frequency HashMap
                    if (charFrequencyMap.containsKey(leftChar)) {
                        // note that we could have redundant matching characters, therefore we'll decrement the
                        // matched count only when the last occurrence of a matched character is going out of the window
                        if (charFrequencyMap.get(leftChar) == 0) {
                            matched--;
                        }
                        charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
                    }
                }
            }
        }

        return minLength > str.length() ? "" : str.substring(subStrStart, subStrStart + minLength);
    }
}